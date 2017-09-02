package com.nagarro.imageutility.dao;

import java.util.List;

import com.nagarro.imageutility.exceptions.UserExceptionClass;
import com.nagarro.imageutility.models.RegisterDetail;

/**
 * The Interface RegisterDao.It defines all the function which is related to
 * database Register User and server access the database with help of these
 * functions
 */
public interface RegisterDao {

	/**
	 * Gets the full name of the user from the database and print in the
	 * browser.
	 *
	 * @param userId
	 *            the user id
	 * @return the full name
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	public String getFullName(int userId) throws UserExceptionClass;

	/**
	 * Gets the password from the database corresponding to the username and
	 * decrypt the password for sending to the mail.
	 *
	 * @param emailId
	 *            the email id
	 * @return the password
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 * @throws Exception
	 *             the exception
	 */
	public String getPassword(String emailId) throws UserExceptionClass, Exception;

	/**
	 * Gets the register details for the registered user from the database aand
	 * used to map with the image list for one to many mapping
	 *
	 * @param userId2
	 *            the user id 2
	 * @return the register details
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	public RegisterDetail getRegisterDetails(int userId2) throws UserExceptionClass;

	/**
	 * Insert values to the register table after singing up by the user and
	 * store the password in the encrypted form.
	 *
	 * @param registerDetails
	 *            the register details
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	public void insertValues(RegisterDetail registerDetails) throws UserExceptionClass;

	/**
	 * Checks if is authenticated.It check the usename and password form the
	 * database for authenticating the user and then send to next page in the
	 * browser for successful login
	 *
	 * @param uname
	 *            the username
	 * @param pass
	 *            the password
	 * @return true, if is authenticated
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	public boolean isAuthenticated(String uname, String pass) throws UserExceptionClass;

	/**
	 * Gets the username list which will used for comparing and the required
	 * username form the database to check is the username available or not.
	 *
	 * @return the username
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	@SuppressWarnings("rawtypes")
	public List getUsername() throws UserExceptionClass;
}
