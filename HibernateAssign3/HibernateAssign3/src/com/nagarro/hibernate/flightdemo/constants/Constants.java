package com.nagarro.hibernate.flightdemo.constants;

/**
 * The Class Constants to store the constant values.
 * 
 * @author ricktamkundu
 */
public class Constants {

	/*
	 * Name of fields that should be used in the string given by user for input
	 * and output
	 */

	/** The Constant FOLDER_PATH which is the current directory. */
	public static final String FOLDER_PATH = ".";

	/**
	 * The Constant RESOURCE_PATH for accessing the properties file from the
	 * resources.
	 */
	public static final String RESOURCE_PATH = "com/nagarro/hibernate/flightdemo/resources/";

	/**
	 * The Constant BUISNESS_CLASS_TAX which is a percentage which will added if
	 * class of a passenger is Business class.
	 */
	public static final double BUISNESS_CLASS_TAX = 1.4;

	/**
	 * The Constant SEARCH_QUERY which search all the flight for a given arrival
	 * and departure location according to the availability.
	 */
	public static final String SEARCH_QUERY = "FROM FlightDetail WHERE Arrival_Location = ? AND  Departure_Location = ?"
			+ " AND Valid_Till > ?  AND Seat_Availibility=?";

}
