package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.exceptions.ErrorFromProperties;
import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class ImageMgmtServlet.This will manage the image
 * input checking the image size and inserting the image in the database
 */
@MultipartConfig(maxFileSize = 1024 * 1024)
@WebServlet("/ImageMgmtServlet")
public class ImageMgmtServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new image mgmt servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageMgmtServlet() {
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

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		Part file = null;
		try {
			file = request.getPart("file");
		} catch (final Exception e) {
			final HttpSession session = request.getSession();
			session.setAttribute("error", ErrorFromProperties.getMessage("FILESIZE"));
			response.sendRedirect(Constants.JSP_PATH + "errorPage.jsp");
			return;
		}
		final String filename = getFilename(file);
		final InputStream filecontent = file.getInputStream();
		final byte[] fileBytes = new byte[(int) file.getSize()];
		filecontent.read(fileBytes);
		filecontent.close();
		int userId = 1;
		userId = Integer.parseInt(request.getParameter("userId"));

		final ImageDetail imageDetails = new ImageDetail();
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
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		LoggerInitialize.LOGGER.debug("File " + filename + " successfully uploaded");

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
				final String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

}
