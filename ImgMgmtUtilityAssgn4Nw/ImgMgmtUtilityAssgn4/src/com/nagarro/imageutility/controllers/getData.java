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

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class getData
 */
@WebServlet("/getData")
public class getData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getData() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		List imageData = new ArrayList<ImageDetail>();

		int userId = Integer.parseInt(request.getParameter("userId"));
		imageData = DataManager.getUserImageData(userId);
		request.setAttribute("imageData", imageData);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/imageDetailsList.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
