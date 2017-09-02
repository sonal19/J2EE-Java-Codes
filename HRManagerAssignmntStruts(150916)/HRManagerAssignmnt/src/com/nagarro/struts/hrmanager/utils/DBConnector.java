package com.nagarro.struts.hrmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;

/**
 * DB Connector that is used to connect the jdbc with the database .
 */
public class DBConnector {

	/** The driver name. */
	private static String driverName;

	/** The connection URL. */
	private static String connectionURL;

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
			Properties props;
			props = ReadFromProperties.readProperties("DBConnection.properties");

			connectionURL = props.getProperty("connectionURL");
			driverName = props.getProperty("driverName");
			
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionURL, props.getProperty("username"),
					props.getProperty("password"));

		} catch (ClassNotFoundException | SQLException e) {
			throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);

		}
		return con;

	}

}
