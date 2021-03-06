package com.nagarro.hibernate.flightdemo.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.hibernate.flightdemo.domain.SearchFlight;
import com.nagarro.hibernate.flightdemo.exception.ErrorCodes;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.utils.ConverterClass;

/**
 * Validate the input string of user by using regular Expressions. It also get
 * the use input data and stores in a HashMapa as key value pairs.
 *
 * @author ricktamkundu
 */
public class UserInputValidation {

	/** The user input string. */
	private static String userInputString;

	/** The pattern search space. */
	private static Pattern patternSpace;

	/** The matcher space. */
	private static Matcher matcherSpace;

	/**
	 * Initialize input with some initial value and getting the user input from
	 * the console.
	 *
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	public static void initializeInput() throws UserExceptionClass {

		/*
		 * Extra Space and hyphen is added to increase the performance
		 */
		userInputString = UserInput.getUserInput() + " ";
		if (userInputString.isEmpty()) {
			throw new UserExceptionClass(ErrorCodes.EMPTYINPUT);
		}
		patternSpace = Pattern.compile(" ");
		matcherSpace = patternSpace.matcher(userInputString);
	}

	/**
	 * Input validator will validate that the input string is proper or not, It
	 * also checks for the any violation on the input string.
	 *
	 * @return string either as error codes or the null to further checking
	 *         purpose
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static SearchFlight inputValidator() throws UserExceptionClass {

		final SearchFlight searchFlights = new SearchFlight();

		initializeInput();

		int startIndex = 0;

		final List<String> itemValue = new ArrayList();
		while (matcherSpace.find()) {

			itemValue.add(userInputString.substring(startIndex, matcherSpace.start()));
			startIndex = matcherSpace.end();

		}

		if (itemValue.get(0).length() != 3 || itemValue.get(1).length() != 3 || !(isValidDate(itemValue.get(2)))
				|| !(itemValue.get(3).equalsIgnoreCase("B")) && !(itemValue.get(3).equalsIgnoreCase("E"))
				|| !(itemValue.get(4).equalsIgnoreCase("fare")) && !(itemValue.get(4).equalsIgnoreCase("both"))) {
			throw new UserExceptionClass(ErrorCodes.INPUTWRONG);
		}

		searchFlights.setDepLoc(itemValue.get(0));
		searchFlights.setArrLoc(itemValue.get(1));
		searchFlights.setFlightDate(ConverterClass.convertStringToDate(itemValue.get(2), "dd-MM-yyyy"));
		searchFlights.setFlightClass(itemValue.get(3));
		searchFlights.setSortedBy(itemValue.get(4));

		return searchFlights;
	}

	/**
	 * Date validity Checker check the validity of the gate and return the
	 * correctness of the date.
	 *
	 * @param inDate
	 *            the in date
	 * @return boolean value for proper date format
	 */
	public static boolean isValidDate(final String inDate) {
		boolean retVal = true;
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (final ParseException pe) {
			retVal = false;
		}
		return retVal;
	}

}