package com.nagarro.flightdemo.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.flightdemo.dto.SearchFlights;
import com.nagarro.flightdemo.presentation.UserInput;
import com.nagarro.flightdemo.utils.ConverterClass;

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
	 * Initialize input.
	 */
	public static void initializeInput() {
		// TODO Auto-generated constructor stub

		/*
		 * Extra Space and hyphen is added to increase the performance
		 */
		userInputString = UserInput.getUserInput();
		if (userInputString.isEmpty()) {
			// throw new UserExceptionClass(ErrorCodes.EMPTYINPUT);
		}
		patternSpace = Pattern.compile(" ");
		matcherSpace = patternSpace.matcher(userInputString);
	}

	/**
	 * Input validator.
	 *
	 * @return string either as error codes or the null to further checking
	 *         purpose
	 */

	public static SearchFlights inputValidator() {

		final SearchFlights searchFlights = new SearchFlights();

		initializeInput();

		int startIndex = 0;

		final ArrayList<String> itemValue = new ArrayList<String>();
		while (matcherSpace.find()) {

			itemValue.add(userInputString.substring(startIndex, matcherSpace.start()));
			startIndex = matcherSpace.end();

		}
		searchFlights.setDepLoc(itemValue.get(0));
		searchFlights.setArrLoc(itemValue.get(1));
		searchFlights.setFlightDate(ConverterClass.convertStringToDate(itemValue.get(2)));
		searchFlights.setFlightClass(itemValue.get(3));
		// searchFlights.setSortedBy(itemValue.get(4));
		searchFlights.setSortedBy("both");

		return searchFlights;
	}

}