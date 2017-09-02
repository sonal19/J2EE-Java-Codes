package com.nagarro.imageutility.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.models.RegisterDetail;

/**
 * The Class DataManager is one the main file which is performing database
 * operation like inserting the values into data, deleting from the database add
 * updating the database.It used on the basis of directory watcher , if there is
 * any changes in the directory it will act and do the needful.
 */
public class DataManager {

	/** The session factory. */
	public static SessionFactory sessionFactory;

	public static int userId;

	/**
	 * Insert to database the values invoked from the CSV files.
	 *
	 * @param registerDetails
	 *            the path of the csv file to read its value
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	public static void insertValues(final RegisterDetail registerDetails) {
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(registerDetails);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
	}

	public static void insertImage(final ImageDetail imageDetails) {
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(imageDetails);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
	}

	public static boolean isAuthenticated(String uname, String pass) {
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		boolean retVal = false;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			int id = (int) session
					.createQuery("Select rd.userId FROM RegisterDetail rd where userName=? and password=?")
					.setString(0, uname).setString(1, pass).uniqueResult();

			Query q = session.createQuery("FROM RegisterDetail where userName=? and password=?");
			q.setString(0, uname);
			q.setString(1, pass);
			if (q.list().isEmpty()) {
				System.out.println("Sorry");
			} else {
				setUserId(id);
				retVal = true;
			}
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return retVal;
	}

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		DataManager.userId = userId;
	}


	public static double getTotalImgSize(int userId) {
		double totalSize=0.0;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			totalSize = (double) session.createQuery("Select sum(id.size) FROM ImageDetail id where registerDetail=? ")
					.setInteger(0, userId).uniqueResult();
			session.getTransaction().commit();

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return totalSize;

	}

	public static long getTableDataCount(int userId) {
		long totalCount = 0;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			totalCount = (long) session.createQuery("Select count(id.registerDetail) FROM ImageDetail id where registerDetail=? ")
					.setInteger(0, userId).uniqueResult();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		
		return totalCount;
	}

	public static String getPassword(String emailId) {
		Session session = null;
		Transaction transaction = null;
		String password = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			// Query passQuery = session.createQuery("FROM RegisterDetail where
			// email=?");
			password = (String) session
					.createQuery("select regDetail.password from RegisterDetail regDetail  where email=?")
					.setString(0, emailId).uniqueResult();
			// passQuery.setString(0, emailId);
			// passQuery.list();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return password;

	}

	public static RegisterDetail getRegisterDetails(int userId2) {
		boolean retVal = false;
		Session session = null;
		Transaction transaction = null;
		RegisterDetail regDetail = new RegisterDetail();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			regDetail = (RegisterDetail) session.get(RegisterDetail.class, userId2);

			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return regDetail;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getUserImageData(int userId) {
		List imageData = new ArrayList<ImageDetail>();
		Session session = null;
		Transaction transaction = null;
		// int userId = Integer.parseInt(request.getParameter("userId"));
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query imageQuery = session.createQuery("FROM ImageDetail where registerDetail=?");
			imageQuery.setInteger(0, userId);
			imageData.addAll(imageQuery.list());

			// request.setAttribute("imageData", imageData);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return imageData;
	}

}
