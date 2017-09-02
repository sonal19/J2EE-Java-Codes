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
import com.nagarro.imageutility.models.ImageDetail;

/**
 * The Class ImgMgmtUtilityDaoImpl which implements the interface
 * ImgMgmtUtilityDao .
 */
public class ImgMgmtUtilityDaoImpl implements ImgMgmtUtilityDao {

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
		ImgMgmtUtilityDaoImpl.userId = userId;
	}

	/**
	 * Instantiates a new img mgmt utility dao impl.
	 */
	public ImgMgmtUtilityDaoImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.ImgMgmtUtilityDao#isImageDeleted(int)
	 */
	@Override
	public boolean isImageDeleted(final int imageId) throws UserExceptionClass {
		boolean retVal = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query imageQuery = session.createQuery(Constants.DELETE_IMAGEDETAIL_QUERY);
			imageQuery.setInteger(0, imageId);
			final int result = imageQuery.executeUpdate();

			if (result > 0) {
				retVal = true;
			}
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
	 * @see com.nagarro.imageutility.dao.ImgMgmtUtilityDao#isImageEdited(int,
	 * java.lang.String)
	 */
	@Override
	public boolean isImageEdited(final int imageId, final String editName) throws UserExceptionClass {
		boolean retVal = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query imageQuery = session.createQuery(Constants.UPDATE_IMAGEDETAIL_QUERY);
			imageQuery.setString(0, editName);
			imageQuery.setInteger(1, imageId);
			final int result = imageQuery.executeUpdate();

			if (result > 0) {
				retVal = true;
			}
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
	 * @see com.nagarro.imageutility.dao.ImgMgmtUtilityDao#getImageStream(int)
	 */
	@Override
	public byte[] getImageStream(final int imageId) throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;
		byte[] imageStream = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			imageStream = (byte[]) session.createQuery(Constants.SELECT_IMAGESTREAM_QUERY).setInteger(0, imageId)
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
		return imageStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.imageutility.dao.ImgMgmtUtilityDao#getTableDataCount(int)
	 */
	@Override
	public long getTableDataCount(final int userId) throws UserExceptionClass {
		long totalCount = 0;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			totalCount = (long) session.createQuery(Constants.COUNT_IMAGES_QUERY).setInteger(0, userId).uniqueResult();
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

		return totalCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.ImgMgmtUtilityDao#getTotalImgSize(int)
	 */
	@Override
	public double getTotalImgSize(final int userId) throws UserExceptionClass {
		double totalSize = 0.0;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			totalSize = (double) session.createQuery(Constants.SUM_IMAGESIZE_QUERY).setInteger(0, userId)
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
		return totalSize;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.imageutility.dao.ImgMgmtUtilityDao#getUserImageData(int)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getUserImageData(final int userId) throws UserExceptionClass {
		final List imageData = new ArrayList<ImageDetail>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query imageQuery = session.createQuery(Constants.SELECT_ALLIMAGE_QUERY);
			imageQuery.setInteger(0, userId);
			imageData.addAll(imageQuery.list());
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
		return imageData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.imageutility.dao.ImgMgmtUtilityDao#insertImage(com.nagarro.
	 * imageutility.models.ImageDetail)
	 */
	@Override
	public void insertImage(final ImageDetail imageDetails) throws UserExceptionClass {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(imageDetails);
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
}
