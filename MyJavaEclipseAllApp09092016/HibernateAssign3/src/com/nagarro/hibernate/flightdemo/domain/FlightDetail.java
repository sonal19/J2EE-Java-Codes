package com.nagarro.hibernate.flightdemo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The Class FlightDetail.The Basic Pojo Class which contains the details of the
 * flight which is also used as a mapping Class This class contribute to
 * database attributes.
 *
 * @author ricktamkundu
 * @serial For sending the objects
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Flight_Details", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "Flight_Number", "airwaysName", "Flight_Time" }) })
public class FlightDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flight id.This is the primary key for the table. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Flight_Id")
	private int flightId;

	/** The flight number which denotes the flight of specific airways */
	@Column(name = "Flight_Number")
	private String flightNum;

	/** The departure location of the flight. */
	@Column(name = "Departure_Location")
	private String depLoc;

	/** The arrival location of the flight. */
	@Column(name = "Arrival_Location")
	private String arrLoc;

	/**
	 * The valid till specifies the last date till when the flight is valid i.e
	 * flight is available before this date.It is used to check with searching
	 * date provided by user
	 */
	@Column(name = "Valid_Till")
	private Date validTill;

	/**
	 * The flight time is the starting time for the flight from source airport.
	 */
	@Column(name = "Flight_Time")
	private String flightTime;

	/** The flight class is mainly of two types E-Economy and B-business. */
	@Column(name = "Flight_Class")
	private String flightClass;

	/**
	 * The flight duration indicates the time taken by the flight to reach its
	 * destination.
	 */
	@Column(name = "Flight_Duration")
	private double flightDuration;

	/**
	 * The fare is the total fare for traveling in that flight. It is used for
	 * sorting on the basis of it.
	 */
	@Column(name = "Fare")
	private double fare;

	/**
	 * The airways name which is mapped from FlightName and act as a foreign
	 * key.It denotes the flight belongs to particular Airways.
	 */
	@ManyToOne
	@JoinColumn(name = "airwaysName")
	private FlightName airwaysName;

	/**
	 * The seat availability gives the availability of seats in the
	 * flight.Either Seats are available or not available
	 */
	@Column(name = "Seat_Availibility")
	private String seatAvailibility;

	/**
	 * The checksum is basically the MessageDigest Hash Value which is
	 * calculated on the basis of all columns in the table and uniquely identify
	 * the table row..
	 *
	 */
	@Column(name = "Checksum")
	private String checksum;

	/**
	 * Gets the checksum.
	 *
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * Sets the checksum.
	 *
	 * @param checksum
	 *            the new checksum
	 */
	public void setChecksum(final String checksum) {
		this.checksum = checksum;
	}

	/**
	 * Gets the airways name.
	 *
	 * @return the airways name
	 */
	public FlightName getAirwaysName() {
		return airwaysName;
	}

	/**
	 * Sets the airways name.
	 *
	 * @param airwaysName
	 *            the new airways name
	 */
	public void setAirwaysName(final FlightName airwaysName) {
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
