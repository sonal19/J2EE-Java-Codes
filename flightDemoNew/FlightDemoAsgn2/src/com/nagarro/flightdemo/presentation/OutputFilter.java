package com.nagarro.flightdemo.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.services.CompareFlights;
import com.nagarro.flightdemo.validation.UserInputValidation;

/**
 * The Class OutputFilter.
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

			try {
				@SuppressWarnings("resource")
				final Scanner scanner = new Scanner(System.in);
				String wantToEnterMore = null;

				do {
					final CompareFlights cf = new CompareFlights();
					cf.setSearchFlights(UserInputValidation.inputValidator());
					cf.comparer(fileMapper);
					UserInput.LOGGER.debug("\n Want to Enter More?");
					wantToEnterMore = scanner.nextLine();

				} while (wantToEnterMore.equalsIgnoreCase("y"));

			} catch (final UserExceptionClass ex) {
				// TODO: handle exception
				// System.out.println(ex.getMessage());
				UserInput.LOGGER.debug(UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID())));
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				UserInput.LOGGER.debug(e);
			}
		}
	}
}
