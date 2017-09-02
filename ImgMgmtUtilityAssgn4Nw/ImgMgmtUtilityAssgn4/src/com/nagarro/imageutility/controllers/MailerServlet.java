package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.services.DataManager;
import com.nagarro.imageutility.services.MailSender;

/**
 * Servlet implementation class MailerServlet
 */
@WebServlet("/MailerServlet")
public class MailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailerServlet() {
        super();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	       String to=request.getParameter("emailId");
	       String subject="Password";
	       String msg="Your Password set is : ";
	       DataManager.sessionFactory=sessionFactory;
	      msg=msg+DataManager.getPassword(to);

	MailSender.sendMail(to, subject, msg);	        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
