package com.nagarro.spring.flightdemo.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * The Class FlightDetail.The Basic Pojo Class which contains the details of the
 * flight which is also used as a mapping Class This class contribute to
 * database attributes.
 *
 * @author ricktamkundu
 * @serial For sending the objects
 */
@Document
public class FlightDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flight id.This is the primary key for the table. */
	@Id
	private int flightId;

	/** The flight number which denotes the flight of specific airways */
	
	private String flightNum;

	/** The departure location of the flight. */
	
	private String depLoc;

	/** The arrival location of the flight. */
	
	private String arrLoc;

	/**
	 * The valid till specifies the last date till when the flight is valid i.e
	 * flight is available before this date.It is used to check with searching
	 * date provided by user
	 */
	
	private String validTill;

	/**
	 * The flight time is the starting time for the flight from source airport.
	 */
	
	private String flightTime;

	/** The flight class is mainly of two types E-Economy and B-business. */
	
	private String flightClass;

	/**
	 * The flight duration indicates the time taken by the flight to reach its
	 * destination.
	 */
	
	private double flightDuration;

	/**
	 * The fare is the total fare for traveling in that flight. It is used for
	 * sorting on the basis of it.
	 */
	
	private double fare;

	/**
	 * The seat availability gives the availability of seats in the
	 * flight.Either Seats are available or not available
	 */
	
	private String seatAvailibility;

	/**
	 * The airways name which is mapped from FlightName and act as a foreign
	 * key.It denotes the flight belongs to particular Airways.
	 */
	private String airwaysName;

	public String getAirwaysName() {
		return airwaysName;
	}

	public void setAirwaysName(String airwaysName) {
		this.airwaysName = airwaysName;
	}

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
	public String getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the new valid till
	 */
	public void setValidTill(final String validTill) {
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
	 * Gets the flight id.
	 *
	 * @return the flight id
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * Sets the flight id.
	 *
	 * @param flightId
	 *            the new flight id
	 */
	public void setFlightId(final int flightId) {
		this.flightId = flightId;
	}

	/**
	 * Override the toString for getting the output format of our choice.
	 *
	 * @return the string
	 */
	/*
	 * 
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
