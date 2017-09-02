/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nagarro.Assignment1.constant.Constants;
import com.nagarro.Assignment1.exception.UserExceptionClass;

/**
 * Take the user input as a string and store the values.User gives the input in
 * the form of -name 1 { -type 2 [ -quantity 3 -price 4 ] }
 * 
 * <p>(1,2,3,4 are fields)</p>
 * 
 * <p>There are four Fields in the input string which contains-: 1. Name of item 2.
 * Type of item (can be of 3 types-raw,imported,manufactured) 3.Quantity of Item
 * 4.Price of Item</p>
 * 
 * <p>{ } -it means the attributes inside this bracket can be kept in any order
 * [ ] -it means the attributes inside this bracket is optional</p>
 *
 * @author ricktamkundu
 */
public class UserInput {

	/** The Constant logger. */
	public static final Logger LOGGER = Logger.getLogger(DisplayAllDetails.class.getName());

	/**
	 * Gets the user input.
	 *
	 * @return String which is entered by the user
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
	public static String getUserInput() throws UserExceptionClass {

		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
		final String consolePrint = String.format(Constants.INPUT_STYLE, Constants.NAME_OF_ITEM, Constants.TYPE_OF_ITEM,
				Constants.PRICE_OF_ITEM, Constants.QUANTITY_OF_ITEM);
		// System.out.printf(Constants.INPUT_STYLE,Constants.NAME_OF_ITEM,Constants.TYPE_OF_ITEM,Constants.PRICE_OF_ITEM,Constants.QUANTITY_OF_ITEM);
		LOGGER.debug(consolePrint);
		final String userInputString = scanner.nextLine();
		LOGGER.info(userInputString);
		return userInputString;

	}

	/**
	 * Initialize the log properties.
	 */
	public static void logInitialization() {
		PropertyConfigurator
				.configure("D:/MyJavaEclipse/Assignment1/resources/com/nagarro/Assignment/resources/log4j.properties");
	}

}
