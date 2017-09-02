package com.nagarro.imageutility.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class RegisterServlet Control all the registration
 * process of the user and store the data
 */
@WebServlet(description = "Control all the registration process of the user and store the data", urlPatterns = {
		"/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SessionFactory sessionFactory;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		final String fullName = request.getParameter("fullname");
		final String email = request.getParameter("email");
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");

		
		final RegisterDetail registerDetails = new RegisterDetail();
		// Using Java Beans - An easiest way to play with group of related data
		registerDetails.setFullName(fullName);
		registerDetails.setEmail(email);
		registerDetails.setUserName(userName);
		registerDetails.setPassword(password);
		
		DataManager.sessionFactory=sessionFactory;
		DataManager.insertValues(registerDetails);
		response.sendRedirect("/ImgMgmtUtilityAssgn4/jsp/register_login.jsp");
		//final RegisterDao registerDao = new RegisterDao();

		/*// The core Logic of the Registration application is present here. We
		// are going to insert user data in to the database.
		final String userRegistered = registerDao.registerUser(registerDetails);

		if (userRegistered.equals("SUCCESS")) // On success, you can display a
												// message to user on Home page
		{
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		}*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		doGet(request, response);
	}

}
