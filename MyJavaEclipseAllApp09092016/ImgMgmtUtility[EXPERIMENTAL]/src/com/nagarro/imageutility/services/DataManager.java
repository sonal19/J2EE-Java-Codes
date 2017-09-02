package com.nagarro.imageutility.services;

import java.util.List;

import com.nagarro.imageutility.dao.ImgMgmtUtilityDao;
import com.nagarro.imageutility.dao.ImgMgmtUtilityDaoImpl;
import com.nagarro.imageutility.dao.RegisterDao;
import com.nagarro.imageutility.dao.RegisterDaoImpl;
import com.nagarro.imageutility.exceptions.UserExceptionClass;
import com.nagarro.imageutility.logger.LoggerInitialize;
import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.models.RegisterDetail;

/**
 * The Class DataManager is one the main file which is performing database
 * operation like inserting the values into data, deleting from the database add
 * updating the database.
 */
public class DataManager {

	/**
	 * The user id is defined uniquely for every user and used for
	 * identification.
	 */
	public static int userId;

	/**
	 * The register dao is the object of the Interface and define the
	 * functionality for implementation.
	 */
	public static RegisterDao registerDao = new RegisterDaoImpl();;

	/**
	 * The img mgmt dao is the object of the Interface and define the
	 * functionality for implementation..
	 */
	public static ImgMgmtUtilityDao imgMgmtDao = new ImgMgmtUtilityDaoImpl();

	/**
	 * Insert values to the register table after singing up by the user and
	 * store the password in the encrypted form.
	 *
	 * @param registerDetails
	 *            the path of the csv file to read its value
	 */
	public static void insertValues(final RegisterDetail registerDetails) {

		try {
			registerDao.insertValues(registerDetails);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
	}

	/**
	 * Insert image will insert the image into the database in the form of byte
	 * stream and also insert image properties like size name etc.
	 *
	 * @param imageDetails
	 *            the image details
	 */
	public static void insertImage(final ImageDetail imageDetails) {
		try {
			imgMgmtDao.insertImage(imageDetails);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
	}

	/**
	 * Checks if is authenticated.It check the usename and password form the
	 * database for authenticating the user and then send to next page in the
	 * browser for successful login
	 *
	 * @param uname
	 *            the uname
	 * @param pass
	 *            the pass
	 * @return true, if is authenticated
	 */
	public static boolean isAuthenticated(final String uname, final String pass) {
		final boolean retVal = false;
		try {
			return registerDao.isAuthenticated(uname, pass);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public static int getUserId() {
		userId = RegisterDaoImpl.getUserId();
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public static void setUserId(final int userId) {
		DataManager.userId = userId;
	}

	/**
	 * Gets the total img size to get the total image in MB uploaded in the
	 * database.
	 *
	 * @param userId
	 *            the user id
	 * @return the total img size
	 */
	public static double getTotalImgSize(final int userId) {
		final double retVal = 0.0;
		try {
			return imgMgmtDao.getTotalImgSize(userId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;

	}

	/**
	 * Gets the table data count to check the number of entry in the table at
	 * the present so that new entry can be made easily.
	 *
	 * @param userId
	 *            the user id
	 * @return the table data count
	 */
	public static long getTableDataCount(final int userId) {
		long retVal = 0;
		try {
			retVal = imgMgmtDao.getTableDataCount(userId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;
	}

	/**
	 * Gets the password from the database corresponding to the username and
	 * decrypt the password for sending to the mail.
	 *
	 * @param emailId
	 *            the email id
	 * @return the password
	 */
	public static String getPassword(final String emailId) {
		String retVal = null;
		try {
			retVal = registerDao.getPassword(emailId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		} catch (final Exception e) {
			LoggerInitialize.LOGGER.debug(e.getMessage());
		}
		return retVal;

	}

	/**
	 * Gets the register details for the registered user from the database aand
	 * used to map with the image list for one to many mapping
	 *
	 * @param userId2
	 *            the user id 2
	 * @return the register details
	 */
	public static RegisterDetail getRegisterDetails(final int userId2) {
		RegisterDetail retVal = null;
		try {
			retVal = registerDao.getRegisterDetails(userId2);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;
	}

	/**
	 * Gets the user image data.It gives the images for each user after the
	 * successful login of the user
	 *
	 * @param userId
	 *            the user id
	 * @return the user image data
	 */
	@SuppressWarnings({ "rawtypes" })
	public static List getUserImageData(final int userId) {
		List retVal = null;
		try {
			retVal = imgMgmtDao.getUserImageData(userId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;
	}

	/**
	 * Gets the image stream and send it to the servlet for showing the image in
	 * the browser.
	 *
	 * @param imageId
	 *            the image id
	 * @return the image stream
	 */
	public static byte[] getImageStream(final int imageId) {
		byte[] retVal = null;
		try {
			retVal = imgMgmtDao.getImageStream(imageId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;

	}

	/**
	 * Checks if is image edited from the database after client click or not.
	 *
	 * @param imageId
	 *            the image id
	 * @param editName
	 *            the edit name
	 * @return true, if successful
	 */
	public static boolean isImageEdited(final int imageId, final String editName) {
		boolean retVal = false;
		try {
			retVal = imgMgmtDao.isImageEdited(imageId, editName);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));

		}
		return retVal;
	}

	/**
	 * Checks if is image deleted from the database or not.
	 *
	 * @param imageId
	 *            the image id
	 * @return true, if successful
	 */
	public static boolean isImageDeleted(final int imageId) {
		boolean retVal = false;
		try {
			retVal = imgMgmtDao.isImageDeleted(imageId);
		} catch (final UserExceptionClass ex) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
		}
		return retVal;

	}

	/**
	 * Gets the username list which will used for comparing and the required
	 * username form the database to check is the username available or not.
	 *
	 * @return the username
	 */
	@SuppressWarnings("rawtypes")
	public static List getUsername() {
		List retVal = null;
		try {
			retVal = registerDao.getUsername();
		} catch (final UserExceptionClass ex) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
		}
		return retVal;

	}

	/**
	 * Gets the full name of the user from the database and print in the
	 * browser.
	 *
	 * @param UserId
	 *            the user id
	 * @return the full name
	 */
	public static String getFullName(final int UserId) {
		String retVal = null;
		try {
			retVal = registerDao.getFullName(UserId);
		} catch (final UserExceptionClass e) {
			LoggerInitialize.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(e.errorCodes.getID())));
		}
		return retVal;

	}
}
