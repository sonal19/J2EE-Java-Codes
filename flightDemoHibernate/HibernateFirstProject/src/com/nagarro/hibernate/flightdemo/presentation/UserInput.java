package com.nagarro.hibernate.flightdemo.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nagarro.hibernate.flightdemo.constants.Constants;

// TODO: Auto-generated Javadoc
/**
 * Take the user input as a string and store the values.User gives the input in
 * the form of Departure Location, Arrival Location, Date, Class, Output
 * Preference
 * 
 *
 * @author ricktamkundu
 */
public class UserInput {

	/** The Constant logger. */
	public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * Gets the user input.
	 *
	 * @return String which is entered by the user
	 */
	public static String getUserInput() {

		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);

		LOGGER.debug(Constants.INPUT_STRING);
		final String userInputString = scanner.nextLine();

		return userInputString;

	}

	/**
	 * Initialize the log properties.
	 */
	public static void logInitialization() {
		PropertyConfigurator.configure(
				"D:/MyJavaEclipse/FlightDemoAsgn2/resources/com/nagarro/flightdemo/resources/log4j.properties");
	}

}