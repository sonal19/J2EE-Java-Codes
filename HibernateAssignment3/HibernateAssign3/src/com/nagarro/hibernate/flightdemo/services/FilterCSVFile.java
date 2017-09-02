package com.nagarro.hibernate.flightdemo.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.utils.CSVReaders;

/**
 * The Class FilterCSVFile.
 * 
 * @author ricktamkundu
 */
public class FilterCSVFile {

	/**
	 * Read CSV file.
	 *
	 * @param path
	 *            the path
	 * @return the array list stores the value of csv files in key value pair
	 *         where key is the name of the file
	 */

	public static HashMap<String, ArrayList<FlightDetails>> filterCSVFile(final String path) {

		final HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();
		if (emptyCheck(path)) {

		}
		final File myDirectory = new File(path);
		final String[] containingFileNames = myDirectory.list();
		/*
		 * if (containingFileNames.length == 0) { throw new
		 * UserExceptionClass(ErrorCodes.NOFILE); }
		 */
		if (containingFileNames == null) {
			if (path.endsWith(".csv")) {
				fileMapper.put(path.replaceAll(".csv", ""), CSVReaders.readCSVFile(path));
			}

		} else {
			for (final String fileName : containingFileNames) {
				if (fileName.endsWith(".csv")) {
					fileMapper.put(fileName.replaceAll(".csv", ""), CSVReaders.readCSVFile(fileName));
				}
			}
		}
		return fileMapper;
	}

	/**
	 * Empty check.
	 *
	 * @param str
	 *            the string for input
	 * @return true, if successful
	 */
	public static boolean emptyCheck(final String str) {
		// Null-safe, short-circuit evaluation.
		return str == null || str.trim().isEmpty();
	}

}
