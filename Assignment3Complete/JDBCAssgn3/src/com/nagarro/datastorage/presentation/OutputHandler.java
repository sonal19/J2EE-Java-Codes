package com.nagarro.datastorage.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.dao.DatabaseConn;
import com.nagarro.datastorage.exception.ErrorCodes;
import com.nagarro.datastorage.exception.UserExceptionClass;
import com.nagarro.datastorage.services.CreateTable;


// TODO: Auto-generated Javadoc
/**
 * The Class OutputHandler.
 */
public class OutputHandler {
	
	/**
	 * Handle output.
	 */
	public static void handleOutput(){
		String wantToEnterMore = null;
		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
		do{
			
		
		try {
			UserInput.getUserInput();
			if(!DatabaseConn.ifDatabaseExists()){
				throw new UserExceptionClass(ErrorCodes.NODATABASE);
				//UserInput.LOGGER.debug(UserExceptionClass.getMessage()));
			}
			if(!DatabaseConn.ifTableExists()){
				CreateTable.createTable();
			}
			
			DatabaseConn.updateQueries(Constants.INSERT_QUERY);
			DatabaseConn.selectQueries(Constants.SELECT_QUERY);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserExceptionClass ex) {
			// TODO Auto-generated catch block
			UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
		}
		
		UserInput.LOGGER.debug("Want to Enter More (Y/y)(Any other Key for No)?");
		wantToEnterMore = scanner.nextLine();
	} while (wantToEnterMore.equalsIgnoreCase("y"));
	}

}
