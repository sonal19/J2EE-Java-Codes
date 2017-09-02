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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
List imageData=new ArrayList<ImageDetail>();
		
		Session session = null; 
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query imageQuery=session.createQuery("FROM ImageDetail");
			imageData.addAll(imageQuery.list());
			
			request.setAttribute("imageData", imageData);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		
		
		request.setAttribute("htmlTagData", "<br/> creates a new line.");
		request.setAttribute("url", "http://www.journaldev.com");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
