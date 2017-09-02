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
 * Servlet implementation class EditImageServlet.It is similar to delete image
 * servlet which edit the image information like name form the database and
 * update it in the database as well as in browser
 */
@WebServlet("/EditImageServlet")
public class EditImageServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new edits the image servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public EditImageServlet() {
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
		System.out.println(request.getParameter("imageId"));

		final int imageId = Integer.parseInt(request.getParameter("imageId"));
		final String editName = request.getParameter("editedName");

		if (DataManager.isImageEdited(imageId, editName)) {
			LoggerInitialize.LOGGER.debug("Successfully updated");
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
