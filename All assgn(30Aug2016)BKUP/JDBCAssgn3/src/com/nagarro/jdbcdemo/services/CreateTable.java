package com.nagarro.jdbcdemo.services;

import java.sql.SQLException;

import com.nagarro.jdbcdemo.constants.Constants;
import com.nagarro.jdbcdemo.dao.DBOperation;
import com.nagarro.jdbcdemo.exception.UserExceptionClass;

/**
 * The Class CreateTable is used to run the create table command to create the
 * table for the first time .
 */
public class CreateTable {

	/**
	 * Creates the table for the first time in the database.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws UserExceptionClass
	 *             the user exception class for custom user exception
	 */
	public static void createTable() throws SQLException, UserExceptionClass {
		final String query = Constants.CREATE_QUERY;
		DBOperation.updateQueries(query);
	}
}
