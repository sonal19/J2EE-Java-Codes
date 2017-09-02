package com.nagarro.imageupload;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.dao.DBConnector;
import com.nagarro.dao.DBOperation;

/**
 * Servlet implementation class ImageUploader
 */
@WebServlet("/ImageUploader")
@MultipartConfig(maxFileSize = 10000000)
public class ImageUploader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public ImageUploader() {
		super();

		// TODO Auto-generated constructor stub
	}
	
	public void printNames(HttpServletRequest request) throws IllegalStateException, IOException, ServletException{
	    for(Part part : request.getParts()){
	        System.out.println("PN: "+ part.getName());
	        Collection<String> headers = part.getHeaders("content-disposition");
	        if (headers == null)
	            continue;
	        for(String header : headers){
	            System.out.println("CDH: " + header);                  
	        } 
	    }
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// gets values of text fields
		String firstName ="firstName";
		String lastName = "lastName";

		InputStream inputStream = null; // input stream of the upload file
		printNames(request);
		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("file");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}

		Connection conn = null; // connection to the database
		String message = null; // message will be sent back to client

		try {
			DBConnector.connectionURL="jdbc:mysql://localhost:3306/test";
			DBConnector.driverName="com.mysql.jdbc.Driver";
			DBOperation.runDB(inputStream, firstName, lastName, message);
			// sets the message in request scope
			request.setAttribute("Message", message);

			// forwards to the message page
			getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
		} catch (Exception e) {
e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
