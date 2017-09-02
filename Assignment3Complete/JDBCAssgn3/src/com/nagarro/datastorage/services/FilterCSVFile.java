package com.nagarro.datastorage.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.datastorage.domain.FlightDetail;
import com.nagarro.datastorage.utils.CSVReaders;

// TODO: Auto-generated Javadoc
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List filterCSVFile(final String path) {

		final List<FlightDetail> flightList = new ArrayList();
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
