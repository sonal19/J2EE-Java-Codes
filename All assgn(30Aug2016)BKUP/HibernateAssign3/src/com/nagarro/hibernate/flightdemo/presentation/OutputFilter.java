package com.nagarro.hibernate.flightdemo.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetail;
import com.nagarro.hibernate.flightdemo.exception.ErrorCodes;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.services.CompareFlights;
import com.nagarro.hibernate.flightdemo.validation.UserInputValidation;

/**
 * The Class OutputFilter which filter the required output in the result list of
 * flights.It gives the search results on the basis of the choice provided by
 * the user.
 * 
 * @author ricktamkundu
 */
public class OutputFilter {

	/**
	 * Output filter filters the required output in the result list of flights.
	 *
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void outputFilter(final Map fileMapper) {

		synchronized (this) {
			String wantToEnterMore = null;
			final Scanner scanner = new Scanner(System.in);

			do {
				try {
					List<FlightDetail> availFlightsList = new ArrayList();
					final CompareFlights compareFlights = new CompareFlights();
					compareFlights.setSearchFlights(UserInputValidation.inputValidator());
					availFlightsList = compareFlights.flightSearch();

					if (availFlightsList != null && availFlightsList.size() > 0) {
						UserInput.LOGGER.debug(ConsoleView.getMessage("OutputMessage"));

						// compareFlights.sortFlights(availFlightsList);

						for (final FlightDetail availFlight : availFlightsList) {
							if (compareFlights.getSearchFlights().getFlightClass().equalsIgnoreCase("B")) {
								availFlight.setFare(availFlight.getFare() * Constants.BUISNESS_CLASS_TAX);
							}
							UserInput.LOGGER.debug(availFlight.toString());
						}
						for (final FlightDetail availFlight : availFlightsList) {
							if (compareFlights.getSearchFlights().getFlightClass().equalsIgnoreCase("B")) {
								availFlight.setFare(availFlight.getFare() / Constants.BUISNESS_CLASS_TAX);
							}
						}

					} else {
						throw new UserExceptionClass(ErrorCodes.NOFLIGHTS);
					}
				} catch (final UserExceptionClass ex) {
					// System.out.println(ex.getMessage());
					UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
				} catch (final Exception e) {
					UserInput.LOGGER.trace(e);
				}
				UserInput.LOGGER.debug("Want to Enter More (Y/y)(Any other Key for No)?");
				wantToEnterMore = scanner.nextLine();
			} while (wantToEnterMore.equalsIgnoreCase("y"));
		}
	}
}
