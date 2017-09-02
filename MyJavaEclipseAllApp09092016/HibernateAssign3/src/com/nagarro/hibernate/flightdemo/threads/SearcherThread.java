package com.nagarro.hibernate.flightdemo.threads;

import java.util.HashMap;
import java.util.Map;

import com.nagarro.hibernate.flightdemo.presentation.OutputFilter;

/**
 * The Class SearcherThread is the another thread which is running and getting
 * the search result from the user.
 * 
 * @author ricktamkundu
 */
public class SearcherThread extends Thread {

	/**
	 * The file mapper stores the value of csv files in key value pair where key
	 * is the name of the file.
	 */
	@SuppressWarnings("rawtypes")
	private transient Map fileMapper = new HashMap();

	/**
	 * Instantiates a new searcher thread.
	 *
	 * @param fileMapper2
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 */
	@SuppressWarnings("rawtypes")
	public SearcherThread(final Map fileMapper2) {
		// TODO Auto-generated constructor stub
		this.fileMapper = fileMapper2;
	}

	/**
	 * Running the thread Class for getting the searched results.
	 */
	/*
	 * Running the thread Class for getting the searched results
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		final OutputFilter filter = new OutputFilter();
		filter.outputFilter(fileMapper);
	}

}
