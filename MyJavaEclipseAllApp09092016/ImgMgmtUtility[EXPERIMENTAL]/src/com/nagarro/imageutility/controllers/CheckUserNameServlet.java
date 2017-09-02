package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class CheckUserNameServlet.It is feature which will
 * used to check for available username from the database and using event it
 * helps to show if user tries to type an username which is already available
 */
@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The session factory. */
	@SuppressWarnings("unused")
	private final SessionFactory sessionFactory;

	/**
	 * Instantiates a new check user name servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserNameServlet() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
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
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		LoggerInitialize.logInitialization();
		response.setContentType("text/html;charset=UTF-8");
		List userName = new ArrayList<String>(15);
		userName = DataManager.getUsername();
		final String user = request.getParameter("uname");
		if (userName.contains(user)) {
			response.getWriter().write("Match");
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
