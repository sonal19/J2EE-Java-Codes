package com.nagarro.hibernate.flightdemo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class SearchFlights.
 * 
 * @author ricktamkundu
 */
public class SearchFlights implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The departure location. */
	private String depLoc;

	/** The arrival location. */
	private String arrLoc;

	/** The flight date. */
	private Date flightDate;

	/** The sorted by. */
	private String sortedBy;

	/** The flight class. */
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
