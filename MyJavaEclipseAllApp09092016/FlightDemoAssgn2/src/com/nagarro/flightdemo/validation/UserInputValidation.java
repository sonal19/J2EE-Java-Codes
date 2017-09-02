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
	 *
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
	public static void initializeInput()  {
		// TODO Auto-generated constructor stub
		
		/*
		 * Extra Space and hyphen is added to increase the performance
		 */
		userInputString = UserInput.getUserInput();
		if (userInputString.isEmpty()) {
			//throw new UserExceptionClass(ErrorCodes.EMPTYINPUT);
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
	
	public static SearchFlights inputValidator(){
		
		SearchFlights searchFlights=new SearchFlights();
		
		initializeInput();
		
		int startIndex = 0; 
		
		ArrayList<String> itemValue = new ArrayList<String>();
		while (matcherSpace.find()) {
			
			itemValue.add( userInputString
					.substring(startIndex,matcherSpace.start()));

			startIndex=matcherSpace.end();
			//index++;
			
	}
		
		searchFlights.setDepLoc(itemValue.get(0));
		searchFlights.setArrLoc(itemValue.get(1));
		searchFlights.setFlightDate(ConverterClass.convertStringToDate(itemValue.get(2)));
		searchFlights.setFlightClass(itemValue.get(3));
		//searchFlights.setSortedBy(itemValue.get(4));
		searchFlights.setSortedBy("both");
		
		return searchFlights;
	}
	/**
	 * Sets the key value pairs.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 *//*
	public static void setKeyValuePairs(final String key, final String value) {

		inputValueHashMap.put(key, value);
	}

	*//**
	 * Key Value Checker.
	 *
	 * @return HashMap with key as fields and value is their respective values
	 *         given by the user in the input
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it.
	 *//*
	public static HashMap<String, String> keyValueChecker() throws UserExceptionClass {

		final ErrorCodes outValue = inputValidator();

		if (outValue != null) {
			throw new UserExceptionClass(outValue);
		}

		if (inputValueHashMap.get(Constants.PRICE_OF_ITEM) == null) {
			inputValueHashMap.remove(Constants.PRICE_OF_ITEM);
		}
		if (inputValueHashMap.get(Constants.QUANTITY_OF_ITEM) == null) {
			inputValueHashMap.remove(Constants.QUANTITY_OF_ITEM);
		}

		return inputValueHashMap;

	}

	*//**
	 * Try parse double.
	 *
	 * @param value
	 *            the value
	 * @return boolean result true if parameter value is parsable in int or
	 *         double else it will return false
	 *//*
	public static boolean tryParseDouble(final String value) {

		boolean retVal = true;
		try {
			final double parsedVal = Double.parseDouble(value);
			if (parsedVal < 0) {
				retVal = false;
			}
		} catch (final NumberFormatException ex) {
			retVal = false;
		} catch (final Exception e) {
			retVal = false;
		}
		return retVal;

	}

	*//**
	 * Try parse integer.
	 *
	 * @param value
	 *            the value
	 * @return true, if successful
	 *//*
	public static boolean tryParseInteger(final String value) {

		boolean retVal = true;
		try {
			final int parsedVal = Integer.parseInt(value);
			if (parsedVal < 0) {
				retVal = false;
			}
		} catch (final NumberFormatException ex) {
			retVal = false;
		} catch (final Exception e) {
			retVal = false;
		}
		return retVal;

	}

	*//**
	 * Item value validator.
	 *
	 * @return Object of Item Details Class which is accessed in the main to
	 *         show the final output
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 *//*
	public static AbstractItemsDetails itemValueValidator() throws UserExceptionClass {
		AbstractItemsDetails returnValue = null;
		HashMap<String, String> itemHashMapDetails = new HashMap<String, String>();

		itemHashMapDetails = keyValueChecker();

		final String itemType = itemHashMapDetails.get(Constants.TYPE_OF_ITEM).toString();
		final String itemName = itemHashMapDetails.get(Constants.NAME_OF_ITEM).toString();

		double itemPrice = 0;
		if (itemHashMapDetails.containsKey(Constants.PRICE_OF_ITEM)) {
			if (tryParseDouble(itemHashMapDetails.get(Constants.PRICE_OF_ITEM).toString())) {
				itemPrice = Double.parseDouble(itemHashMapDetails.get(Constants.PRICE_OF_ITEM).toString());
			} else {
				throw new UserExceptionClass(ErrorCodes.EMPTYPRICE);
			}
		}

		int itemQuantity = 0;
		if (itemHashMapDetails.containsKey(Constants.QUANTITY_OF_ITEM)) {
			if (tryParseInteger(itemHashMapDetails.get(Constants.QUANTITY_OF_ITEM).toString())) {
				itemQuantity = Integer.parseInt(itemHashMapDetails.get(Constants.QUANTITY_OF_ITEM).toString());
			} else {
				throw new UserExceptionClass(ErrorCodes.EMPTYQUANTITY);
			}
		}
		returnValue = ManageItems.itemsTaxManager(itemHashMapDetails, itemType, itemName, itemQuantity, itemPrice);

		return returnValue;
	}*/
		
}