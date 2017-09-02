package com.nagarro.datastorage.services;

import java.io.File;
import java.util.ArrayList;

import com.nagarro.datastorage.domain.FlightDetails;
import com.nagarro.datastorage.utils.CSVReaders;

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
	public static ArrayList<FlightDetails> filterCSVFile(final String path) {

		final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		final File myDirectory = new File(path);
		final String[] containingFileNames = myDirectory.list();
		/*
		 * if (containingFileNames.length == 0) { throw new
		 * UserExceptionClass(ErrorCodes.NOFILE); }
		 */
		for (final String fileName : containingFileNames) {
			if (fileName.endsWith(".csv")) {
				flightList.addAll(CSVReaders.readCSVFile(fileName));
			}
		}
		return flightList;
	}

}
