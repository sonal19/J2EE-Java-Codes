package com.nagarro.hibernate.flightdemo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class FlightDetails.
 * 
 * @serial For sending the objects
 * 
 * @author ricktamkundu
 */
@Entity
@Table(name="Flight_Details")
public class FlightDetails {

	/** The flight number. */
	@Id
	@Column (name="Flight_Number")
	private String flightNum;

	/** The departure location. */
	@Column (name="Departure_Location")
	private String depLoc;

	/** The arrival location. */
	@Column (name="Arrival_Location")
	private String arrLoc;

	/** The valid till. */
	@Column (name="Valid_Till")
	private Date validTill;

	/** The flight time. */
	@Column (name="Flight_Time")
	private String flightTime;

	/** The flight class. */
	@Column (name="Flight_Class")
	private String flightClass;

	/** The flight duration. */
	@Column (name="Flight_Duration")
	private double flightDuration;

	/** The fare. */
	@Column (name="Fare")
	private double fare;

	/** The seat availability. */
	@Column (name="Seat_Availibility")
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
	 * Override the toString for getting the out format of our choice
	 *//*
	
	 * Override the to string for getting the out format of our choice
	 * 
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {

		return flightNum + " | " + depLoc + " | " + arrLoc + " | " + validTill + " | "

				+ flightTime + " | " + flightDuration + " | " + fare + " | " + flightClass;

	}*/
}
