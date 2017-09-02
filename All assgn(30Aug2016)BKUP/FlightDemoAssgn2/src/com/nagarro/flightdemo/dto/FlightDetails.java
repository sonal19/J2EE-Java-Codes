package com.nagarro.flightdemo.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightDetails.
 * 
 * @serial For sending the objects
 */
public class FlightDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flight num. */
	private String flightNum;

	/** The departure loc. */
	private String depLoc;

	/** The arrival loc. */
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

	/** The seat availibility. */
	private String seatAvailibility;

	/**
	 * Gets the flight num.
	 *
	 * @return the flight num
	 */
	public String getFlightNum() {
		return flightNum;
	}

	/**
	 * Sets the flight num.
	 *
	 * @param flightNum
	 *            the new flight num
	 */
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

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
	public void setValidTill(Date validTill) {
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
	public void setFlightTime(String flightTime) {
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
	public void setFlightClass(String flightClass) {
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
	public void setFlightDuration(double flightDuration) {
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
	public void setFare(double fare) {
		this.fare = fare;
	}

	/**
	 * Gets the seat availibility.
	 *
	 * @return the seat availibility
	 */
	public String getSeatAvailibility() {
		return seatAvailibility;
	}

	/**
	 * Sets the seat availibility.
	 *
	 * @param seatAvailibility
	 *            the new seat availibility
	 */
	public void setSeatAvailibility(String seatAvailibility) {
		this.seatAvailibility = seatAvailibility;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return flightNum + "|" + depLoc + "|" + arrLoc + "|" + validTill + "|"

				+ flightTime + "|" + flightDuration + "|" + fare;

	}
}
