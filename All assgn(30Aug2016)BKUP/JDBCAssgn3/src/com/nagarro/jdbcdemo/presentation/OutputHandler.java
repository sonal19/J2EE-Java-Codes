package com.nagarro.jdbcdemo.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.nagarro.jdbcdemo.constants.Constants;
import com.nagarro.jdbcdemo.dao.DBOperation;
import com.nagarro.jdbcdemo.exception.ErrorCodes;
import com.nagarro.jdbcdemo.exception.UserExceptionClass;
import com.nagarro.jdbcdemo.services.CreateTable;

/**
 * The Class OutputHandler Handles the output of the console window and also
 * handles the database operation for showing the results.
 */
public class OutputHandler {

	/**
	 * Handle output that has to be shown in the console output.
	 */
	public static void handleOutput() {
		String wantToEnterMore = null;
		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
		do {

			try {
				UserInput.getUserInput();
				if (!DBOperation.ifDatabaseExists()) {
					throw new UserExceptionClass(ErrorCodes.NODATABASE);
				}
				if (!DBOperation.ifTableExists()) {
					CreateTable.createTable();
				}
				DBOperation.updateQueries(Constants.INSERT_QUERY);
				DBOperation.selectQueries(Constants.SELECT_QUERY);
			} catch (final SQLException e) {
				UserInput.LOGGER.trace(e.getMessage());
			} catch (final UserExceptionClass ex) {
				UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
			}

			UserInput.LOGGER.debug("Want to Enter More (Y/y)(Any other Key for No)?");
			wantToEnterMore = scanner.nextLine();
		} while (wantToEnterMore.equalsIgnoreCase("y"));
	}

}
