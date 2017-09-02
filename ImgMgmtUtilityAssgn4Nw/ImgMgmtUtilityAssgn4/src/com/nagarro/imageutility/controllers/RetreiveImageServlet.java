package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.io.OutputStream;
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
 * Servlet implementation class RetreiveImageServlet
 */
@WebServlet("/RetreiveImageServlet")
public class RetreiveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetreiveImageServlet() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		Session session = null;
		Transaction transaction = null;
		List<ImageDetail> imageData = new ArrayList<>();
		ImageDetail imageDetails = new ImageDetail();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		// Get image from database
		Query imageQuery = session.createQuery("FROM ImageDetail");
		imageData.addAll(imageQuery.list());
		session.getTransaction().commit();
		OutputStream oImage;
		byte[] bAvatar = imageData.get(1).getImageStream();

		try {

			response.setContentType("image/jpg");
			oImage = response.getOutputStream();
			oImage.write(bAvatar);

			oImage.flush();
			oImage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
