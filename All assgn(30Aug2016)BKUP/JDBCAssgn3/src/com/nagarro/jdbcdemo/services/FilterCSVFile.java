package com.nagarro.jdbcdemo.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.jdbcdemo.domain.FlightDetail;
import com.nagarro.jdbcdemo.utils.CSVReaders;

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
	public static List filterCSVFile(final String path) {

		final List<FlightDetail> flightList = new ArrayList();
		final File myDirectory = new File(path);
		final String[] containingFileNames = myDirectory.list();

		for (final String fileName : containingFileNames) {
			if (fileName.endsWith(".csv")) {
				flightList.addAll(CSVReaders.readCSVFile(fileName));
			}
		}
		return flightList;
	}

}
