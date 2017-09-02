package com.nagarro.imageutility.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.exceptions.ErrorFromProperties;
import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.services.DataManager;
import com.nagarro.imageutility.utils.EncryptionDecryptionAES;

/**
 * Servlet implementation class LoginServlet.It is used handle login information
 * provided by the user by getting the username and password from the user
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The session factory. */
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	/**
	 * Instantiates a new login servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		try {
			if (DataManager.isAuthenticated(userName, EncryptionDecryptionAES.encrypt(password))) {
				response.sendRedirect(Constants.JSP_PATH + "imageMgmt.jsp?userId=" + DataManager.getUserId());
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("error", ErrorFromProperties.getMessage("401"));
				response.sendRedirect(Constants.JSP_PATH + "errorPage.jsp");
			}
		} catch (Exception e) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
