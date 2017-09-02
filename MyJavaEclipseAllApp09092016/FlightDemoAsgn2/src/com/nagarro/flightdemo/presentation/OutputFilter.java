package com.nagarro.flightdemo.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.nagarro.flightdemo.constant.Constants;
import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.exception.ErrorCodes;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.services.CompareFlights;
import com.nagarro.flightdemo.validation.UserInputValidation;

/**
 * The Class OutputFilter which filter the required output in the result list of
 * flights.
 * 
 * @author ricktamkundu
 */
public class OutputFilter {

	/**
	 * Output filter.
	 *
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 */

	public void outputFilter(final HashMap<String, ArrayList<FlightDetails>> fileMapper) {

		synchronized (this) {
			String wantToEnterMore = null;
			final Scanner scanner = new Scanner(System.in);

			do {
				try {
					ArrayList<FlightDetails> availFlightsList = new ArrayList<FlightDetails>();
					final CompareFlights compareFlights = new CompareFlights();
					compareFlights.setSearchFlights(UserInputValidation.inputValidator());
					availFlightsList = compareFlights.comparer(fileMapper);

					if (availFlightsList != null && availFlightsList.size() > 0) {
						UserInput.LOGGER.debug(Constants.OUTPUT_STRING);

						compareFlights.sortFlights(availFlightsList);

						for (final FlightDetails availFlight : availFlightsList) {
							if (compareFlights.getSearchFlights().getFlightClass().equalsIgnoreCase("B")) {
								availFlight.setFare(availFlight.getFare() * Constants.BUISNESS_CLASS_TAX);
							}
							UserInput.LOGGER.debug(availFlight.toString());
						}
						for (final FlightDetails availFlight : availFlightsList) {
							if (compareFlights.getSearchFlights().getFlightClass().equalsIgnoreCase("B")) {
								availFlight.setFare(availFlight.getFare() / Constants.BUISNESS_CLASS_TAX);
							}
						}

					} else {
						throw new UserExceptionClass(ErrorCodes.NOFLIGHTS);
					}
				} catch (final UserExceptionClass ex) {
					// TODO: handle exception
					// System.out.println(ex.getMessage());
					UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					UserInput.LOGGER.debug(e);
				}
				UserInput.LOGGER.debug("Want to Enter More (Y/y)(Any other Key for No)?");
				wantToEnterMore = scanner.nextLine();
			} while (wantToEnterMore.equalsIgnoreCase("y"));
		}
	}
}
