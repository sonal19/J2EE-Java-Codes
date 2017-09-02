package com.nagarro.imageutility.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.exceptions.ErrorFromProperties;
import com.nagarro.imageutility.services.DataManager;
import com.nagarro.imageutility.services.MailSender;

/**
 * Servlet implementation class MailerServlet which handle the mailing request
 * it works on SMTP protocol and here it is used to send the password whe user
 * forget its password.
 */
@WebServlet("/MailerServlet")
public class MailerServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new mailer servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public MailerServlet() {
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

		final String to = request.getParameter("emailId");
		final String subject = "Password";
		final String msg = DataManager.getPassword(to);

		final String msgBody = "Your Password set is : " + msg;
		if (msg == null) {
			final HttpSession session = request.getSession();
			session.setAttribute("error", ErrorFromProperties.getMessage("MAILERROR"));
			response.sendRedirect(Constants.JSP_PATH + "errorPage.jsp");
		} else {
			MailSender.sendMail(to, subject, msgBody);
			final HttpSession session = request.getSession();
			session.setAttribute("error", "Mail Sent Please check Your Inbox");
			response.sendRedirect(Constants.JSP_PATH + "errorPage.jsp");
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
