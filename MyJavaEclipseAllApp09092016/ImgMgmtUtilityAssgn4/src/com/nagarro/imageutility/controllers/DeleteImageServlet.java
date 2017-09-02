package com.nagarro.imageutility.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class DeleteImageServlet which is used to control the
 * deletion of images from the server on user click.
 */
@WebServlet("/DeleteImageServlet")
public class DeleteImageServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new delete image servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteImageServlet() {
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

		if (DataManager.isImageDeleted(imageId)) {
			LoggerInitialize.LOGGER.debug("Successfully deleted");
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
