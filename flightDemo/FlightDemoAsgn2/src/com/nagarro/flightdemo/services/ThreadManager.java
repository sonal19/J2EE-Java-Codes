package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.constant.Constants;
import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.threads.DirectoryWatcher;

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
