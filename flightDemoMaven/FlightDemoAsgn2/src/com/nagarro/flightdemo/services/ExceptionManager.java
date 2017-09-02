package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.presentation.UserInput;
import com.nagarro.flightdemo.threads.SearcherThread;

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
		} catch (final UserExceptionClass ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
		} catch (final Exception ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			UserInput.LOGGER.debug(ex.getMessage());
		}

	}
}
