package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class RetreiveImageServlet helps to get the image from
 * the database using byte stream and show it in the browser
 */
@WebServlet("/RetreiveImageServlet")
public class RetreiveImageServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new retreive image servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public RetreiveImageServlet() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		final int imageId = Integer.parseInt(request.getParameter("imageId"));
		DataManager.getImageStream(imageId);
		OutputStream oImage;
		final byte[] bAvatar = DataManager.getImageStream(imageId);
		try {
			response.setContentType("image/jpg"); // for image type
			oImage = response.getOutputStream();
			oImage.write(bAvatar);
			oImage.flush();
			oImage.close();
		} catch (final Exception e) {
			LoggerInitialize.LOGGER.debug(e.getMessage());
		}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
