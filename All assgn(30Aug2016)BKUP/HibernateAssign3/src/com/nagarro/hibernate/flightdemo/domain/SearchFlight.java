package com.nagarro.hibernate.flightdemo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class SearchFlight.This is a basic class which contains the information
 * about the searching that should be configured for finding the flight
 * Details.It is used for the user Input information.
 * 
 * @author ricktamkundu
 */
public class SearchFlight implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The departure location of the flight given by user. */
	private String depLoc;

	/** The arrival location of the flight given by user. */
	private String arrLoc;

	/**
	 * The flight date when the user want to book the flight and search the
	 * flight.
	 */
	private Date flightDate;

	/**
	 * The sorted by gives the option that how the output user want to see,
	 * sorting is basically on fare and flight duration
	 */
	private String sortedBy;

	/**
	 * The flight class is the class the user want to search for either business
	 * class or Economy class.
	 */
	private String flightClass;

	/**
	 * Gets the departure location.
	 *
	 * @return the departure location
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * Sets the departure location.
	 *
	 * @param depLoc
	 *            the new departure location
	 */
	public void setDepLoc(final String depLoc) {
		this.depLoc = depLoc;
	}

	/**
	 * Gets the arrival location.
	 *
	 * @return the arrival location
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * Sets the arrival location.
	 *
	 * @param arrLoc
	 *            the new arrival location.
	 */
	public void setArrLoc(final String arrLoc) {
		this.arrLoc = arrLoc;
	}

	/**
	 * Gets the flight date.
	 *
	 * @return the flight date
	 */
	public Date getFlightDate() {
		return flightDate;
	}

	/**
	 * Sets the flight date.
	 *
	 * @param flightDate
	 *            the new flight date
	 */
	public void setFlightDate(final Date flightDate) {
		this.flightDate = flightDate;
	}

	/**
	 * Gets the sorted by.
	 *
	 * @return the sorted by
	 */
	public String getSortedBy() {
		return sortedBy;
	}

	/**
	 * Sets the sorted by.
	 *
	 * @param sortedBy
	 *            the new sorted by
	 */
	public void setSortedBy(final String sortedBy) {
		this.sortedBy = sortedBy;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flight class
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the new flight class
	 */
	public void setFlightClass(final String flightClass) {
		this.flightClass = flightClass;
	}

}
