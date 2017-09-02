package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.threads.SearcherThread;

/**
 * The Class ExceptionManager.
 */
public class ExceptionManager {
	
	/**
	 * Handle exception.
	 *
	 * @return the string
	 */
	public static String handleException() {

		String retOutput = null;
		try {

			HashMap<String,ArrayList<FlightDetails>>  fileMapper=new HashMap<String,ArrayList<FlightDetails>>();
			fileMapper = FilterCSVFile.filterCSVFile(".");
			
			SearcherThread thread=new SearcherThread(fileMapper);
			thread.start();
			
			ThreadManager.threadManager(fileMapper);
			// System.out.println(output);
		} catch (UserExceptionClass ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			retOutput = UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID()));
		} catch (final Exception ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			retOutput = ex.getMessage();
		}
		return retOutput;

	}
}
