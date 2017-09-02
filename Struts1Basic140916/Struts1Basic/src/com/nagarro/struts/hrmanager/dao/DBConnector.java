package com.nagarro.struts.hrmanager.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.nagarro.struts.hrmanager.constants.Constants;
import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;


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
			String resourceName =Constants.RESOURCE_PATH+"DBConnection.properties"; // could also be a constant
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Properties props = new Properties();
			try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			    props.load(resourceStream);
						
				// get the property value and print it out
				System.out.println(props.getProperty("username"));
				System.out.println(props.getProperty("password"));
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionURL, props.getProperty("username"), props.getProperty("password"));

		} catch (ClassNotFoundException | SQLException e) {
			throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);

		}
		return con;

	}

}
