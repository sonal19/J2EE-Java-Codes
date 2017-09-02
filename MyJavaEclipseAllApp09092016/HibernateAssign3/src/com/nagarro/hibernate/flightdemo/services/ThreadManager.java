package com.nagarro.hibernate.flightdemo.services;

import java.util.Map;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.threads.DirectoryWatcher;

/**
 * The Class ThreadManager which is managing the thread and controlling the
 * directory watcher state in it.
 * 
 * @author ricktamkundu
 */
public class ThreadManager {

	/**
	 * Thread manager getting the thread state of directory watcher and
	 * Continuously managing it.
	 *
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 * @return the hash map stores the value of csv files in key value pair
	 *         where key is the name of the file
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	@SuppressWarnings("rawtypes")
	public static Map threadManager(final Map fileMapper) throws UserExceptionClass {
		return DirectoryWatcher.directoryWatch(Constants.FOLDER_PATH, fileMapper);
	}

}
