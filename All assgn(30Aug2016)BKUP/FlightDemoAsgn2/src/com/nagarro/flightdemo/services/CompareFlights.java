package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.dto.SearchFlights;
import com.nagarro.flightdemo.exception.UserExceptionClass;

/**
 * The Class CompareFlights will compare the details between the all flights
 * details and the flight wanted and finds the required best possible flights
 * available.
 * 
 * @author ricktamkundu
 */
public class CompareFlights {

	/** The search flights. */
	private SearchFlights searchFlights;

	/**
	 * Comparer.
	 *
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 * @return the array list
	 */
	public ArrayList<FlightDetails> comparer(final HashMap<String, ArrayList<FlightDetails>> fileMapper) {

		final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		final ArrayList<FlightDetails> availFlightsList = new ArrayList<FlightDetails>();

		for (final String keyset : fileMapper.keySet()) {
			flightList.addAll(fileMapper.get(keyset));
		}
		if (getSearchFlights() != null) {

			for (final FlightDetails item : flightList) {

				if (item.getDepLoc().equalsIgnoreCase(searchFlights.getDepLoc())
						&& item.getArrLoc().equalsIgnoreCase(searchFlights.getArrLoc())
						&& item.getSeatAvailibility().equalsIgnoreCase("y")) {

					if (item.getValidTill().compareTo(searchFlights.getFlightDate()) >= 0) {

						if (item.getFlightClass().contains(searchFlights.getFlightClass())) {

							availFlightsList.add(item);
						}
					}
				}
			}

		}
		return availFlightsList;

	}

	/**
	 * Sort flights.
	 *
	 * @param availFlightsList
	 *            the avail flights list
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	public void sortFlights(final ArrayList<FlightDetails> availFlightsList) throws UserExceptionClass {

		Collections.sort(availFlightsList, new Comparator<FlightDetails>() {
			/**
			 * Overrides compare method of collection.sort class which is used
			 * to compare two flight details and return the status of the result
			 * 
			 * @return integer value which gives the comparision status
			 */
			@Override
			public int compare(final FlightDetails object1, final FlightDetails object2) {
				final int fareComp = Double.compare(object1.getFare(), object2.getFare());
				if (searchFlights.getSortedBy().equalsIgnoreCase("both")) {
					if (fareComp != 0) {
						return fareComp;
					}
					final int durComp = Double.compare(object1.getFlightDuration(), object2.getFlightDuration());
					return durComp;
				}
				return fareComp;
			}
		});

	}

	/**
	 * Gets the search flights.
	 *
	 * @return the search flights Object
	 */
	public SearchFlights getSearchFlights() {
		return searchFlights;
	}

	/**
	 * Sets the search flights.
	 *
	 * @param searchFlights
	 *            the new search flights
	 */
	public void setSearchFlights(final SearchFlights searchFlights) {
		this.searchFlights = searchFlights;
	}

}
