package com.nagarro.flightdemo.threads;

import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.presentation.OutputFilter;

/**
 * The Class SearcherThread.
 */
public class SearcherThread extends Thread {

	/**
	 * The file mapper stores the value of csv files in key value pair where key
	 * is the name of the file.
	 */
	private HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();

	/**
	 * Instantiates a new searcher thread.
	 *
	 * @param fileMapper
	 *              the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 */
	public SearcherThread(final HashMap<String, ArrayList<FlightDetails>> fileMapper) {
		// TODO Auto-generated constructor stub
		this.fileMapper = fileMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		OutputFilter filter = new OutputFilter();
		filter.outputFilter(fileMapper);
	}

}
