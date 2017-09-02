package com.nagarro.flightdemo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.dto.SearchFlights;

public class CompareFlights {

	private SearchFlights searchFlights;

	public void comparer() {

		ArrayList<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
		ArrayList<FlightDetails> availFlightsList = new ArrayList<FlightDetails>();

		flightDetailsList = FilterCSVFile.readCSVFile(".");

		if (getSearchFlights() != null) {

			for (FlightDetails item : flightDetailsList) {

				if (item.getDepLoc().equalsIgnoreCase(searchFlights.getDepLoc())
						&& item.getArrLoc().equalsIgnoreCase(searchFlights.getArrLoc())) {

					if (item.getValidTill().compareTo(searchFlights.getFlightDate()) >= 0) {

						availFlightsList.add(item);

					}
				}
			}
		}

		if (availFlightsList != null && availFlightsList.size() > 0) {

			System.out.println("FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE");

			System.out.println("------------------------------------------------------------------");

			Collections.sort(availFlightsList, new Comparator<FlightDetails>() {

				@Override

				public int compare(FlightDetails o1, FlightDetails o2) {

					int fareComp = Double.compare(o1.getFare(), o2.getFare());

					if (searchFlights.getSortedBy().equalsIgnoreCase("both")) {

						if (fareComp != 0) {

							return fareComp;

						}

						int durComp = Double.compare(o1.getFlightDuration(), o2.getFlightDuration());

						return durComp;

					}

					return fareComp;

				}

			});

			for (FlightDetails availFlight : availFlightsList) {

				System.out.println(availFlight.toString());

			}

		}

		else {

			System.out.println("Search criteria is not provided.....");

		}

	}

	public SearchFlights getSearchFlights() {
		return searchFlights;
	}

	public void setSearchFlights(SearchFlights searchFlights) {
		this.searchFlights = searchFlights;
	}

}
