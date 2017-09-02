package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImageMgmtServlet
 */
@MultipartConfig
@WebServlet("/ImageMgmtServlet")
public class ImageMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageMgmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Part file = request.getPart("file");
	        String filename = getFilename(file);
	        InputStream filecontent = file.getInputStream();
	        // ... Do your file saving job here.

	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("File " + filename + " successfully uploaded");
	        System.out.println("File " + filename + " successfully uploaded");
	    }

	    private static String getFilename(Part part) {
	        for (String cd : part.getHeader("content-disposition").split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	            }
	        }
	        return null;
	    }

}
