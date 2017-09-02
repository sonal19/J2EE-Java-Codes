package com.nagarro.datastorage.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.nagarro.datastorage.constants.Constants;

public class UserInput {
	
	/** The Constant logger. */
	public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static String userName;
	public static String password;
	/**
	 * Gets the user input.
	 *
	 * @return String which is entered by the user
	 */
	public static void getUserInput() {

		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);

		//LOGGER.debug(Constants.INPUT_STRING);
		userName = scanner.nextLine();
		
		password = scanner.nextLine();

		

	}
}
