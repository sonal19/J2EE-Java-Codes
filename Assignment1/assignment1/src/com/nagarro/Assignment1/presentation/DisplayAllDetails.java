/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.presentation;

import java.util.Scanner;

import com.nagarro.Assignment1.exception.UserExceptionClass;
import com.nagarro.Assignment1.services.impl.ExceptionHandler;

/**
 * It contains the main method and basically served as a presentation for user
 * It contains all function calling and print output in log. It request for more
 * inputs or exit the application
 *
 * @author ricktamkundu
 */
public class DisplayAllDetails {

	/**
	 * Main Function.
	 *
	 * @param args
	 *            the arguments
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
	@SuppressWarnings("resource")
	public static void main(final String args[]) throws UserExceptionClass {

		UserInput.logInitialization();
		final Scanner scanner = new Scanner(System.in);
		String wantToEnterMore = null;
		do {

			UserInput.LOGGER.debug(ExceptionHandler.handleException());
			// System.out.print("Want to Enter more (Y/y) (Press any key to
			// exit): ");
			UserInput.LOGGER.debug("Want to Enter more (Y/y) (Press any key to exit): ");
			wantToEnterMore = scanner.nextLine();

		} while (wantToEnterMore.equalsIgnoreCase("y"));

	}

}
