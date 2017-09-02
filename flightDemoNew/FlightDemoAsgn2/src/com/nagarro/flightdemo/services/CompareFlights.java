package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.nagarro.flightdemo.constant.Constants;
import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.dto.SearchFlights;
import com.nagarro.flightdemo.exception.ErrorCodes;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.presentation.UserInput;

/**
 * The Class CompareFlights.
 */
public class CompareFlights {

	/** The search flights. */
	private SearchFlights searchFlights;

	/**
	 * Comparer.
	 *
	 * @param fileMapper the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 * @throws UserExceptionClass the user exception class
	 */
	public void comparer(final HashMap<String, ArrayList<FlightDetails>> fileMapper) throws UserExceptionClass {

		final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		final ArrayList<FlightDetails> availFlightsList = new ArrayList<FlightDetails>();

		for (final String keyset : fileMapper.keySet()) {
			flightList.addAll(fileMapper.get(keyset));
		}
		if (getSearchFlights() != null) {

			for (final FlightDetails item : flightList) {

				if (item.getDepLoc().equalsIgnoreCase(searchFlights.getDepLoc())
						&& item.getArrLoc().equalsIgnoreCase(searchFlights.getArrLoc())) {
					if (item.getSeatAvailibility().equalsIgnoreCase("y")) {

						if (item.getValidTill().compareTo(searchFlights.getFlightDate()) >= 0) {

							if (item.getFlightClass().contains(searchFlights.getFlightClass())) {

								if (searchFlights.getFlightClass().equalsIgnoreCase("B")) {
									item.setFare(item.getFare() * Constants.BUISNESS_CLASS_TAX);
									availFlightsList.add(item);
								} else {
									availFlightsList.add(item);
								}

							}

						}
					}
				}
			}
		}

		if (availFlightsList != null && availFlightsList.size() > 0) {
			UserInput.LOGGER.debug("FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE");
			UserInput.LOGGER.debug("------------------------------------------------------------------");

			Collections.sort(availFlightsList, new Comparator<FlightDetails>() {
				@Override
				public int compare(final FlightDetails o1, final FlightDetails o2) {
					final int fareComp = Double.compare(o1.getFare(), o2.getFare());
					if (searchFlights.getSortedBy().equalsIgnoreCase("both")) {
						if (fareComp != 0) {
							return fareComp;
						}
						final int durComp = Double.compare(o1.getFlightDuration(), o2.getFlightDuration());
						return durComp;
					}
					return fareComp;
				}
			});

			for (final FlightDetails availFlight : availFlightsList) {
				UserInput.LOGGER.debug(availFlight.toString());
			}
		} else {
			throw new UserExceptionClass(ErrorCodes.NOFLIGHTS);
		}
	}

	/**
	 * Gets the search flights.
	 *
	 * @return the search flights
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
