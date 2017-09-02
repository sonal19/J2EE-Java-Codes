package com.nagarro.jdbcdemo.presentation;

import java.sql.SQLException;

/**
 * The Class MainClass for calling the function and it contains the main method.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static void main(final String[] args) throws SQLException {

		UserInput.logInitialization();
		OutputHandler.handleOutput();
	}

}
