package com.nagarro.struts.hrmanager.controllers;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.cfg.Configuration;

import com.nagarro.struts.hrmanager.services.EmployeeService;
import com.nagarro.struts.hrmanager.services.EmployeeServiceImpl;
import com.nagarro.struts.hrmanager.utils.CSVReaders;



/**
 * Servlet implementation class AddEmployeeServlet.This will manage the image
 * input checking the image size and inserting the image in the database
 */
@MultipartConfig
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new image mgmt servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
		super();
		}

	/**
	 * Do post.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		Part file = null;
		try {
			file = request.getPart("file");
		} catch (final Exception e) {
			final HttpSession session = request.getSession();
			//session.setAttribute("error", ErrorFromProperties.getMessage("FILESIZE"));
			//response.sendRedirect(Constants.JSP_PATH + "errorPage.jsp");
			return;
		}
		
		 
		final String filename = getFilename(file);
		System.out.println("----------->>>>>");
		final InputStream filecontent = file.getInputStream();
		final byte[] fileBytes = new byte[(int) file.getSize()];
		filecontent.read(fileBytes);
		filecontent.close();
		
		 //create a temp file
	    File temp = File.createTempFile("tempfile.csv", ".tmp");

    //write it
	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
	   
	    //String s = null;
	  // char ch[] = null;
	   CharBuffer chbuff = CharBuffer.allocate(1024);
		for (int i = 0; i < fileBytes.length; i++) {
			//chbuff.append(c)
			//chbuff.append((char)fileBytes[i]);
			chbuff.put(i, (char)fileBytes[i]);
			//ch[i]=((char)fileBytes[i]);
			 bw.write((char)fileBytes[i]);
	       	System.out.print((char)fileBytes[i]);
            }
		 bw.close();
		//int s = null;
		
		//s=s.read(chbuff);
		 List empList=new ArrayList<>();
		 empList.addAll(CSVReaders.readCSVFile(temp));
		EmployeeService empService=new EmployeeServiceImpl();
		empService.addEmployee(empList);
		//int userId = 1;
		//userId = Integer.parseInt(request.getParameter("userId"));

		/*final ImageDetail imageDetails = new ImageDetail();
		imageDetails.setImageStream(fileBytes);
		imageDetails.setName(filename);
		imageDetails.setSize(round(file.getSize(), 2));

		RegisterDetail registerDetails = new RegisterDetail();

		registerDetails = DataManager.getRegisterDetails(userId);

		imageDetails.setRegisterDetail(registerDetails);
		double totalSize = 0.0;
		totalSize = DataManager.getTotalImgSize(userId);
		if (totalSize + imageDetails.getSize() < 10.0) {
			DataManager.insertImage(imageDetails);
		}*/

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		//LoggerInitialize.LOGGER.debug("File " + filename + " successfully uploaded");

	}

	/**
	 * Round.
	 *
	 * @param value
	 *            the value
	 * @param places
	 *            the places
	 * @return the double
	 */
	public static double round(final double value, final int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value / (1024 * 1024));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Gets the filename.
	 *
	 * @param part
	 *            the part
	 * @return the filename
	 */
	private static String getFilename(final Part part) {
		for (final String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				System.out.println(cd.toString());
				final String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

}
