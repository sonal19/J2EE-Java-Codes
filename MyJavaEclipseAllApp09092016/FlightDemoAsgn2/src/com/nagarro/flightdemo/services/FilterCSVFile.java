package com.nagarro.flightdemo.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.exception.ErrorCodes;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.utils.CSVReaders;

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
	 * @throws UserExceptionClass
	 *             the user exception class which handles if file is not
	 *             available
	 */
	public static HashMap<String, ArrayList<FlightDetails>> filterCSVFile(final String path) throws UserExceptionClass {

		final HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();
		final File myDirectory = new File(path);
		final String[] containingFileNames = myDirectory.list();
		if (containingFileNames.length == 0) {
			throw new UserExceptionClass(ErrorCodes.NOFILE);
		}
		for (final String fileName : containingFileNames) {
			if (fileName.endsWith(".csv")) {
				fileMapper.put(fileName, CSVReaders.readCSVFile(fileName));
			}
		}
		return fileMapper;
	}

}
