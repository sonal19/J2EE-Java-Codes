package com.nagarro.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.nagarro.jdbcdemo.exception.ErrorCodes;
import com.nagarro.jdbcdemo.exception.UserExceptionClass;
import com.nagarro.jdbcdemo.presentation.UserInput;

/**
 * DB Connector that is used to connect the jdbc with the database .
 */
public class DBConnector {

	/** The driver name. */
	public static String driverName;

	/** The connection URL. */
	public static String connectionURL;

	/**
	 * Gets the connection by using connection url and driver name.
	 *
	 * @return the connection
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exception
	 */
	public static Connection getConnection() throws UserExceptionClass {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionURL, UserInput.getUserName(), UserInput.getPassword());

		} catch (ClassNotFoundException | SQLException e) {
			throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);

		}
		return con;

	}

}
