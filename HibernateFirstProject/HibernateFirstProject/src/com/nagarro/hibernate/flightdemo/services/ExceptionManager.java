package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.threads.SearcherThread;


// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionManager.
 * 
 * @author ricktamkundu
 */
public class ExceptionManager {

	/**
	 * Handle all exception.
	 *
	 */
	public static void handleException() {

		try {

			HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();
			fileMapper = FilterCSVFile.filterCSVFile(".");

			final SearcherThread thread = new SearcherThread(fileMapper);
			thread.start();

			ThreadManager.threadManager(fileMapper);
			// System.out.println(output);
		} /*catch (final UserExceptionClass ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
		} */catch (final Exception ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			UserInput.LOGGER.debug(ex.getMessage());
		}

	}
}
