package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class RetreiveImgDataServlet.
 */
@WebServlet("/RetreiveImgDataServlet")
public class RetreiveImgDataServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new retreive img data servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public RetreiveImgDataServlet() {
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
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List imageData = new ArrayList<ImageDetail>();

		int userId = Integer.parseInt(request.getParameter("userId"));

		imageData = DataManager.getUserImageData(userId);
		request.setAttribute("imageData", imageData);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/imageDetailsList.jsp?userId=" + userId);
		rd.forward(request, response);

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
