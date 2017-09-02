package com.nagarro.imageutility.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.services.DataManager;
import com.nagarro.imageutility.utils.EncryptionDecryptionAES;

/**
 * Servlet implementation class RegisterServlet Control all the registration
 * process of the user and store the data in the database.
 */
@WebServlet(description = "Control all the registration process of the user and store the data", urlPatterns = {
		"/RegisterServlet" })
public class RegisterServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The session factory is used to define the session from the configuration
	 * file for the first time.
	 */
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	/**
	 * Instantiates a new register servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		final String fullName = request.getParameter("fullname");
		final String email = request.getParameter("email");
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");

		final RegisterDetail registerDetails = new RegisterDetail();
		registerDetails.setFullName(fullName);
		registerDetails.setEmail(email);
		registerDetails.setUserName(userName);
		try {
			registerDetails.setPassword(EncryptionDecryptionAES.encrypt(password));
		} catch (Exception e) {
			LoggerInitialize.LOGGER.debug(e.getMessage());
		}

		DataManager.insertValues(registerDetails);
		response.sendRedirect(Constants.JSP_PATH + "register_login.jsp");

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

		doGet(request, response);
	}

}
