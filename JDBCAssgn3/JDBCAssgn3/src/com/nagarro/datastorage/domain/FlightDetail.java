package com.nagarro.datastorage.domain;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightDetail.
 *
 * @author ricktamkundu
 * @serial For sending the objects
 */
public class FlightDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flight number. */
	private String flightNum;

	/** The departure location. */
	private String depLoc;

	/** The arrival location. */
	private String arrLoc;

	/** The valid till. */
	private Date validTill;

	/** The flight time. */
	private String flightTime;

	/** The flight class. */
	private String flightClass;

	/** The flight duration. */
	private double flightDuration;

	/** The fare. */
	private double fare;

	/** The seat availability. */
	private String seatAvailibility;

	/**
	 * Gets the flight number.
	 *
	 * @return the flight number
	 */
	public String getFlightNum() {
		return flightNum;
	}

	/**
	 * Sets the flight number.
	 *
	 * @param flightNum
	 *            the new flight number
	 */
	public void setFlightNum(final String flightNum) {
		this.flightNum = flightNum;
	}

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
	 *            the new arrival location
	 */
	public void setArrLoc(final String arrLoc) {
		this.arrLoc = arrLoc;
	}

	/**
	 * Gets the valid till.
	 *
	 * @return the valid till
	 */
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the new valid till
	 */
	public void setValidTill(final Date validTill) {
		this.validTill = validTill;
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flight time
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the new flight time
	 */
	public void setFlightTime(final String flightTime) {
		this.flightTime = flightTime;
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

	/**
	 * Gets the flight duration.
	 *
	 * @return the flight duration
	 */
	public double getFlightDuration() {
		return flightDuration;
	}

	/**
	 * Sets the flight duration.
	 *
	 * @param flightDuration
	 *            the new flight duration
	 */
	public void setFlightDuration(final double flightDuration) {
		this.flightDuration = flightDuration;
	}

	/**
	 * Gets the fare.
	 *
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * Sets the fare.
	 *
	 * @param fare
	 *            the new fare
	 */
	public void setFare(final double fare) {
		this.fare = fare;
	}

	/**
	 * Gets the seat availability.
	 *
	 * @return the seat availability
	 */
	public String getSeatAvailibility() {
		return seatAvailibility;
	}

	/**
	 * Sets the seat availability.
	 *
	 * @param seatAvailibility
	 *            the new seat availability
	 */
	public void setSeatAvailibility(final String seatAvailibility) {
		this.seatAvailibility = seatAvailibility;
	}

	/**
	 * Override the toString for getting the out format of our choice.
	 *
	 * @return the string
	 */
	/*
	 * Override the to string for getting the out format of our choice
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return flightNum + " | " + depLoc + " | " + arrLoc + " | " + validTill + " | "

				+ flightTime + " | " + flightDuration + " | " + fare + " | " + flightClass;

	}
}
