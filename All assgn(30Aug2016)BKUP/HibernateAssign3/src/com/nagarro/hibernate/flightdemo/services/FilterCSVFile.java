package com.nagarro.hibernate.flightdemo.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.utils.CSVReaders;

/**
 * The Class FilterCSVFile is used to filter only the csv files form the
 * directory and ignoring remaining other file present in the directory.
 * 
 * @author ricktamkundu
 */
public class FilterCSVFile {

	/**
	 * Read CSV file after filtering the CSV file from the directory and also
	 * reads csv files as well as directory.
	 *
	 * @param path
	 *            the path of the file or the directory contains csv files
	 * @return the array list stores the value of csv files in key value pair
	 *         where key is the name of the file
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map filterCSVFile(final String path) {
		final String csvExtension = ".csv";
		final HashMap fileMapper = new HashMap();
		if (emptyCheck(path)) {
			UserInput.LOGGER.trace("Enpty path!!");
		}
		final File myDirectory = new File(path);
		final String[] containingFileNames = myDirectory.list();

		if (containingFileNames == null) {
			if (path.endsWith(csvExtension)) {
				fileMapper.put(path.replaceAll(csvExtension, ""), CSVReaders.readCSVFile(path));
			}

		} else {
			for (final String fileName : containingFileNames) {
				if (fileName.endsWith(csvExtension)) {
					fileMapper.put(fileName.replaceAll(csvExtension, ""), CSVReaders.readCSVFile(fileName));
				}
			}
		}
		return fileMapper;
	}

	/**
	 * Empty check checks if the string is null or not.
	 *
	 * @param str
	 *            the string for input
	 * @return true, if successful i.e it is null
	 */
	public static boolean emptyCheck(final String str) {
		// Null-safe, short-circuit evaluation.
		return str == null || str.trim().isEmpty();
	}

}
