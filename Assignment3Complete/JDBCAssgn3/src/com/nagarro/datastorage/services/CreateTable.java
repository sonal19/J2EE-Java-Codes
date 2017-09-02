package com.nagarro.datastorage.services;

import java.sql.SQLException;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.dao.DatabaseConn;
import com.nagarro.datastorage.exception.UserExceptionClass;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateTable.
 */
public class CreateTable {

	/**
	 * Creates the table.
	 *
	 * @throws SQLException the SQL exception
	 * @throws UserExceptionClass the user exception class
	 */
	public static void createTable() throws SQLException, UserExceptionClass {
		final String query =Constants.CREATE_QUERY;
		DatabaseConn.updateQueries(query);
	}
}
