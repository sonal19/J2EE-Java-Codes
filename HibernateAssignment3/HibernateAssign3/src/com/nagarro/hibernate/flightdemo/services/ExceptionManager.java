package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.threads.SearcherThread;

/**
 * The Class ExceptionManager.
 * 
 * @author ricktamkundu
 */
public class ExceptionManager {

	/**
	 * Handle all exception.
	 *
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	public static void handleException() throws UserExceptionClass {

		try {

			HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();
			fileMapper = FilterCSVFile.filterCSVFile(".");

			final SearcherThread thread = new SearcherThread(fileMapper);
			thread.start();

			ThreadManager.threadManager(fileMapper);
			// System.out.println(output);
		} catch (final Exception ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			UserInput.LOGGER.debug(ex.getMessage());
		}

	}
}
