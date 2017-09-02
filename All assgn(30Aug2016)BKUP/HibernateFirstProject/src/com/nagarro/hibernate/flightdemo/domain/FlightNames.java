package com.nagarro.hibernate.flightdemo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class FlightNames.
 */
@Entity
@Table(name="Flight_Names")
public class FlightNames {

	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="Airways_Id")
	private int airwaysId;
	
	public int getAirwaysId() {
		return airwaysId;
	}

	public void setAirwaysId(int airwaysId) {
		this.airwaysId = airwaysId;
	}*/

	/** The airways. */
	@Id
	@Column(name="AirwayName")
	private String airways;
	
	
	/** The flight details. */
	@OneToMany(targetEntity=FlightDetails.class, mappedBy="airwaysName", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<FlightDetails> flightList;
	
	
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
	 * @param airways the new airways
	 */
	public void setAirways(String airways) {
		this.airways = airways;
	}
	
		
	/**
	 * Gets the flight list.
	 *
	 * @return the flight list
	 */
	public List<FlightDetails> getFlightList() {
		return flightList;
	}

	/**
	 * Sets the flight list.
	 *
	 * @param flightList the new flight list
	 */
	public void setFlightList(List<FlightDetails> flightList) {
		this.flightList = flightList;
	}
}
