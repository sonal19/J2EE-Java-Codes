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

	/** The Constant FOLDER_PATH. */
	public static final String FOLDER_PATH = ".";

	/** The Constant BUISNESS_CLASS_TAX. */
	public static final double BUISNESS_CLASS_TAX = 1.4;

	/** The Constant INPUT_STRING. */
	public static final String INPUT_STRING = "Enter:- Depurture Location(3 letters), Arrival Location(3 letters), "
			+ "Date(DD-MM-YYYY), Class(E/B), OutPref(Fare/both) \n [e.g- DEL MUB 05-12-2013 E both]: ";

	/** The Constant OUTPUT_STRING. */
	public static final String OUTPUT_STRING = "FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE|CLASS ";

	/** The Constant SEARCH_QUERY. */
	public static final String SEARCH_QUERY = "FROM FlightDetails WHERE Arrival_Location = ? AND  Departure_Location = ?"
			+ " AND Valid_Till > ?  AND Seat_Availibility=?";

}
