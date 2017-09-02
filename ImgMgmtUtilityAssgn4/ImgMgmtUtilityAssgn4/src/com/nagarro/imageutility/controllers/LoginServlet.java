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

import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("AvailableData", DataManager.getTableDataCount());
		
		if(DataManager.isAuthenticated(userName, password)){
			response.sendRedirect("/ImgMgmtUtilityAssgn4/jsp/imageMgmt.jsp");
		}
		else{
			System.out.println("Sorry");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
