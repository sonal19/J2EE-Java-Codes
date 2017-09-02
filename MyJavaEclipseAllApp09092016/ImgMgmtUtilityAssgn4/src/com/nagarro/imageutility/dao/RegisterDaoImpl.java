package com.nagarro.imageutility.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.exceptions.ErrorCodes;
import com.nagarro.imageutility.exceptions.UserExceptionClass;
import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.utils.EncryptionDecryptionAES;

/**
 * The Class RegisterDaoImpl.
 */
public class RegisterDaoImpl implements RegisterDao {

	/** The session factory. */
	public static SessionFactory sessionFactory;

	/**
	 * The user id is defined uniquely for every user and used for
	 * identification.
	 */
	public static int userId;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public static int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public static void setUserId(final int userId) {
		RegisterDaoImpl.userId = userId;
	}

	/**
	 * Instantiates a new register dao impl.
	 */
	public RegisterDaoImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.RegisterDao#getFullName(int)
	 */
	@Override
	public String getFullName(final int userId) throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;
		String fname = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			fname = (String) session.createQuery(Constants.SELECT_FULLNAME_QUERY).setInteger(0, userId).uniqueResult();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}
		return fname;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.imageutility.dao.RegisterDao#getPassword(java.lang.String)
	 */
	@Override
	public String getPassword(final String emailId) throws Exception {
		Session session = null;
		Transaction transaction = null;
		String password = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			password = (String) session.createQuery(Constants.SELECT_PASSWORD_QUERY).setString(0, emailId)
					.uniqueResult();

			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}
		return EncryptionDecryptionAES.decrypt(password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.RegisterDao#getRegisterDetails(int)
	 */
	@Override
	public RegisterDetail getRegisterDetails(final int userId2) throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;
		RegisterDetail regDetail = new RegisterDetail();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			regDetail = (RegisterDetail) session.get(RegisterDetail.class, userId2);

			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}
		return regDetail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.RegisterDao#insertValues(com.nagarro.
	 * imageutility.models.RegisterDetail)
	 */
	@Override
	public void insertValues(final RegisterDetail registerDetails) throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(registerDetails);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.RegisterDao#isAuthenticated(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public boolean isAuthenticated(final String uname, final String pass) throws UserExceptionClass {
		boolean retVal = false;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final int id = (int) session.createQuery(Constants.SELECT_USERID_QUERY).setString(0, uname)
					.setString(1, pass).uniqueResult();

			setUserId(id);
			retVal = true;

			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.RegisterDao#getUsername()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getUsername() throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;
		List uname = new ArrayList<String>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query query = session.createQuery(Constants.SELECT_USERNAME_QUERY);
			uname = query.list();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			LoggerInitialize.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);

			}
		} catch (final RuntimeException ex) {
			LoggerInitialize.LOGGER.trace(ex.getMessage());
			throw new UserExceptionClass(ErrorCodes.NORESOURCE);
		}
		return uname;
	}
}
