package com.nagarro.datastorage.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.services.DatabaseManager;


// TODO: Auto-generated Javadoc
/**
 * The Class UserInput.
 */
public class UserInput {
	
	/** The Constant logger. */
	public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	/** The user name. */
	private static String userName;
	
	/** The password. */
	private static String password;
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public static String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public static void setUserName(String userName) {
		UserInput.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public static void setPassword(String password) {
		UserInput.password = password;
	}
	
	/** The database type. */
	public static int databaseType;
	/**
	 * Gets the user input.
	 *
	 * @return String which is entered by the user
	 */
	public static void getUserInput() {

		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
		LOGGER.debug(ConsoleView.getMessage("Credentials"));
		setUserName(scanner.next());
		 setPassword(scanner.next());
		
		
		LOGGER.debug(ConsoleView.getMessage("InputMessage"));
		databaseType=scanner.nextInt();
		
		DatabaseManager.manageDatabase(databaseType);
		
	}
	
	/**
	 * Log initialization.
	 */
	public static void logInitialization() {
		PropertyConfigurator.configure("resources/" + Constants.RESOURCE_PATH + "log4j.properties");
	}

}
