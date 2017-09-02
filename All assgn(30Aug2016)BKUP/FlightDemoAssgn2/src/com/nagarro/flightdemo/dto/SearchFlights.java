package com.nagarro.flightdemo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class SearchFlights.
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
	
	private String flightClass;

	/**
	 * Gets the departure loc.
	 *
	 * @return the departure loc
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * Sets the departure loc.
	 *
	 * @param depLoc
	 *            the new departure loc
	 */
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	/**
	 * Gets the arr loc.
	 *
	 * @return the arr loc
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * Sets the arr loc.
	 *
	 * @param arrLoc
	 *            the new arr loc
	 */
	public void setArrLoc(String arrLoc) {
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
	public void setFlightDate(Date flightDate) {
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
	public void setSortedBy(String sortedBy) {
		this.sortedBy = sortedBy;
	}
	
	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
