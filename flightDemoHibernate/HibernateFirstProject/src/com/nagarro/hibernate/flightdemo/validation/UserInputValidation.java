package com.nagarro.hibernate.flightdemo.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.hibernate.flightdemo.domain.SearchFlights;
import com.nagarro.hibernate.flightdemo.exception.ErrorCodes;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.nagarro.hibernate.flightdemo.utils.ConverterClass;


// TODO: Auto-generated Javadoc
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
	 *
	 * @throws UserExceptionClass the user exception class
	 */
	public static void initializeInput() throws UserExceptionClass {
		// TODO Auto-generated constructor stub

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
	 * Input validator.
	 *
	 * @return string either as error codes or the null to further checking
	 *         purpose
	 * @throws UserExceptionClass
	 *             the user exception class
	 */

	public static SearchFlights inputValidator() throws UserExceptionClass {

		final SearchFlights searchFlights = new SearchFlights();

		initializeInput();

		int startIndex = 0;

		final ArrayList<String> itemValue = new ArrayList<String>();
		while (matcherSpace.find()) {

			itemValue.add(userInputString.substring(startIndex, matcherSpace.start()));
			startIndex = matcherSpace.end();

		}

		if (itemValue.get(0).length() != 3 || itemValue.get(1).length() != 3 || !(isValidDate(itemValue.get(2)))
				|| (!(itemValue.get(3).equalsIgnoreCase("B")) && !(itemValue.get(3).equalsIgnoreCase("E")))
				|| (!(itemValue.get(4).equalsIgnoreCase("fare")) && !(itemValue.get(4).equalsIgnoreCase("both")))) {
			throw new UserExceptionClass(ErrorCodes.INPUTWRONG);
		}

		searchFlights.setDepLoc(itemValue.get(0));
		searchFlights.setArrLoc(itemValue.get(1));
		searchFlights.setFlightDate(ConverterClass.convertStringToDate(itemValue.get(2)));
		searchFlights.setFlightClass(itemValue.get(3));
		searchFlights.setSortedBy(itemValue.get(4));

		return searchFlights;
	}

	/**
	 * Date validity Checker.
	 *
	 * @param inDate the in date
	 * @return boolean value for proper date format
	 */
	public static boolean isValidDate(String inDate) {
		boolean retVal = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			retVal = false;
		}
		return retVal;
	}

}