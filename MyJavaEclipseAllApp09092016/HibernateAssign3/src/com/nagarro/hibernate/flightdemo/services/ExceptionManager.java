package com.nagarro.hibernate.flightdemo.services;

import java.util.HashMap;
import java.util.Map;

import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.threads.SearcherThread;

/**
 * The Class ExceptionManager manages the exception that is caused from the
 * different Threads.
 * 
 * @author ricktamkundu
 */
public class ExceptionManager {

	/**
	 * Handle all exception caused in the execution of the program and store it
	 * in the Logger.
	 *
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	public static void handleException() throws UserExceptionClass {

		try {

			@SuppressWarnings("rawtypes")
			Map fileMapper = new HashMap();
			fileMapper = FilterCSVFile.filterCSVFile(".");

			final SearcherThread thread = new SearcherThread(fileMapper);
			thread.start();

			ThreadManager.threadManager(fileMapper);
			// System.out.println(output);
		} catch (final Exception ex) {

			UserInput.LOGGER.debug(ex.getMessage());
		}

	}
}
