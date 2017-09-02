package com.nagarro.datastorage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.nagarro.datastorage.exception.ErrorCodes;
import com.nagarro.datastorage.exception.UserExceptionClass;
import com.nagarro.datastorage.presentation.UserInput;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DAO objects.
 */
public class DAOFactory {

	/** The driver name. */
	public static String driverName;
	
	/** The connection URL. */
	public static String connectionURL;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws UserExceptionClass the user exception class
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

	/**
	 * Map params.
	 *
	 * @param ps the ps
	 * @param args the args
	 * @throws SQLException the SQL exception
	 */
	public static void mapParams(PreparedStatement ps, Object... args) throws SQLException {
		int i = 1;
		for (Object arg : args) {
			if (arg instanceof Date) {
				ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
			} else if (arg instanceof Integer) {
				ps.setInt(i++, (Integer) arg);
			} else if (arg instanceof Long) {
				ps.setLong(i++, (Long) arg);
			} else if (arg instanceof Double) {
				ps.setDouble(i++, (Double) arg);
			} else if (arg instanceof Float) {
				ps.setFloat(i++, (Float) arg);
			} else {
				ps.setString(i++, (String) arg);
			}
		}
	}

}
