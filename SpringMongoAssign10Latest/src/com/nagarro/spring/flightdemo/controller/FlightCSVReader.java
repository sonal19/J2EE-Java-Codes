package com.nagarro.spring.flightdemo.controller;

import java.io.File;
import java.util.List;

public interface FlightCSVReader {
	
	/**
	 * Read CSV file from the given directory and the path and parse it on the
	 * basis of the given delimiter in the csv file.
	 *
	 * @param file the file
	 * @return the array list after storing the results from the given csv files
	 */
	@SuppressWarnings("rawtypes")
	List readCSVFile(File file, String airwaysName, int flightCount);
}
