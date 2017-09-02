package com.nagarro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * * DB Connector that is used to connect the jdbc with the database .
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
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionURL, "root","tom");

		} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
		}
		return con;

	}

}
