package com.nagarro.hibernate.flightdemo.services;

import java.util.Map;

import com.nagarro.hibernate.flightdemo.constants.Constants;
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
	@SuppressWarnings("rawtypes")
	public static Map threadManager(final Map fileMapper) {
		return DirectoryWatcher.directoryWatch(Constants.FOLDER_PATH, fileMapper);
	}

}
