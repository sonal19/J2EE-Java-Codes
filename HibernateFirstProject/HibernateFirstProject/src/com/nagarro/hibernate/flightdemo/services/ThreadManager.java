package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.threads.DirectoryWatcher;



// TODO: Auto-generated Javadoc
/**
 * The Class ThreadManager.
 * 
 * @author ricktamkundu
 */
public class ThreadManager {

	/**
	 * Thread manager.
	 *
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 * @return the hash map stores the value of csv files in key value pair
	 *         where key is the name of the file
	 */
	public static HashMap<String, ArrayList<FlightDetails>> threadManager(
			final HashMap<String, ArrayList<FlightDetails>> fileMapper) {
		return DirectoryWatcher.directoryWatch(Constants.FOLDER_PATH, fileMapper);
	}

}
