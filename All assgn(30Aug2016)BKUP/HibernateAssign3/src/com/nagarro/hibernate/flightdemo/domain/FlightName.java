package com.nagarro.hibernate.flightdemo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class FlightName.This is a basic Pojo class also a mapping class which
 * contains the information about the airways name and used to map with the Main
 * database table configured using FlightDetails
 */
@Entity
@Table(name = "Flight_Names")
public class FlightName implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The airways.This acts as a primary key which contains the name of the
	 * Airways that belongs to the given CSV data and acts as a foreign key for
	 * the Flight_Details Table and mapped to it.
	 */
	@Id
	@Column(name = "AirwayName")
	private String airways;

	/**
	 * The flight details.It contains the list of the flight details which comes
	 * under a particular airlines and connected to it using foreign key
	 * Constraints
	 */
	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity = FlightDetail.class, mappedBy = "airwaysName", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List flightList;

	/**
	 * Gets the airways.
	 *
	 * @return the airways
	 */
	public String getAirways() {
		return airways;
	}

	/**
	 * Sets the airways.
	 *
	 * @param airways
	 *            the new airways
	 */
	public void setAirways(final String airways) {
		this.airways = airways;
	}

	/**
	 * Gets the flight list.
	 *
	 * @return the flight list
	 */
	@SuppressWarnings("rawtypes")
	public List getFlightList() {
		return flightList;
	}

	/**
	 * Sets the flight list.
	 *
	 * @param flightList
	 *            the new flight list
	 */
	@SuppressWarnings("rawtypes")
	public void setFlightList(final List flightList) {
		this.flightList = flightList;
	}
}
