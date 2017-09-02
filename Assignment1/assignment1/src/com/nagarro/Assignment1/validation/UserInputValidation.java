/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.validation;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.Assignment1.constant.Constants;
import com.nagarro.Assignment1.domain.AbstractItemsDetails;
import com.nagarro.Assignment1.exception.UserExceptionClass;
import com.nagarro.Assignment1.exception.ErrorCodes;
import com.nagarro.Assignment1.presentation.UserInput;
import com.nagarro.Assignment1.services.impl.ManageItems;

/**
 * Validate the input string of user by using regular Expressions. It also get
 * the use input data and stores in a HashMapa as key value pairs.
 *
 * @author ricktamkundu
 */
public class UserInputValidation {

	/** The user input string. */
	private static String userInputString;

	/** The pattern search hyphen. */
	private static Pattern patternHyphen;

	/** The pattern search space. */
	private static Pattern patternSpace;

	/** The matcher hyphen. */
	private static Matcher matcherHyphen;

	/** The matcher space. */
	private static Matcher matcherSpace;

	/** The input value hash map. */
	private static HashMap<String, String> inputValueHashMap;

	/** The dash delimator. */
	private static String dashDelimator;

	/**
	 * Initialize input.
	 *
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
	public static void initializeInput() throws UserExceptionClass {
		// TODO Auto-generated constructor stub
		dashDelimator = "-";
		inputValueHashMap = new HashMap<String, String>();
		/*
		 * Extra Space and hyphen is added to increase the performance
		 */
		userInputString = UserInput.getUserInput() + " - ";
		if (userInputString.isEmpty()) {
			throw new UserExceptionClass(ErrorCodes.EMPTYINPUT);
		}

		patternHyphen = Pattern.compile(dashDelimator);
		patternSpace = Pattern.compile(" ");
		matcherHyphen = patternHyphen.matcher(userInputString);
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
	public static ErrorCodes inputValidator() throws UserExceptionClass {

		ErrorCodes retVal = null;
		initializeInput();
		boolean typeFound = false;
		int firstCount = 0; // first time run of code
		String checkString = null;
		String itemValue = null;
		int duplicateType = 0;
		int duplicateQuantity = 0;
		int duplicatePrice = 0;

		while (matcherHyphen.find() && matcherSpace.find(matcherHyphen.start())) {

			itemValue = userInputString
					.substring(matcherSpace.start(),
							matcherSpace.start() + (userInputString.substring(matcherSpace.end()).indexOf(" -")) + 1)
					.trim();

			checkString = userInputString.substring(matcherHyphen.end(), matcherSpace.start());
			if (firstCount == 0) {
				/*
				 * For checking the name Input
				 */
				if (!(checkString.equalsIgnoreCase(Constants.NAME_OF_ITEM))) {
					retVal = ErrorCodes.FIRSTINPUTNAME;
					break;
				} else {
					if (itemValue.contains(dashDelimator + Constants.TYPE_OF_ITEM)
							|| itemValue.equalsIgnoreCase(dashDelimator + Constants.PRICE_OF_ITEM)
							|| itemValue.equalsIgnoreCase(dashDelimator + Constants.QUANTITY_OF_ITEM)) {
						retVal = ErrorCodes.EMPTYNAME;
						break;
					} else {
						setKeyValuePairs(Constants.NAME_OF_ITEM, itemValue);
						firstCount++;
						continue;
					}
				}
			}

			if (checkString.equalsIgnoreCase(Constants.NAME_OF_ITEM)) {
				retVal = ErrorCodes.DUPLICATENAME;
			}
			/*
			 * For checking the Type Input
			 */
			if (checkString.equalsIgnoreCase(Constants.TYPE_OF_ITEM)) {
				if (itemValue.equalsIgnoreCase("raw") || itemValue.equalsIgnoreCase("imported")
						|| itemValue.equalsIgnoreCase("manufactured")) {
					setKeyValuePairs(Constants.TYPE_OF_ITEM, itemValue);
					duplicateType++;
					typeFound = true;
					continue;
				} else {
					retVal = ErrorCodes.NOTAVAILABLETYPES;
					break;
				}
			}
			/*
			 * For checking the Price Input
			 */
			if (checkString.equalsIgnoreCase(Constants.PRICE_OF_ITEM)) {
				setKeyValuePairs(Constants.PRICE_OF_ITEM, itemValue);
				duplicatePrice++;
				continue;
			}
			/*
			 * For checking the Quantity Input
			 */
			if (checkString.equalsIgnoreCase(Constants.QUANTITY_OF_ITEM)) {
				setKeyValuePairs(Constants.QUANTITY_OF_ITEM, itemValue);
				duplicateQuantity++;
				continue;
			}
		}
		/*
		 * For checking unwanted non expressive input
		 */
		if (retVal != null) {
			return retVal;
		}
		/*
		 * For checking the type is present or not
		 */
		if (!typeFound) {
			retVal = ErrorCodes.EMPTYTYPE;
			return retVal;
		}
		retVal = duplicateValidator(duplicatePrice, duplicateType, duplicateQuantity);

		return retVal;
	}

	/**
	 * Duplicate validator for checking duplicate occurrence.
	 *
	 * @param duplicatePrice
	 *            the duplicate price
	 * @param duplicateType
	 *            the duplicate type
	 * @param duplicateQuantity
	 *            the duplicate quantity
	 * @return the error codes
	 */
	public static ErrorCodes duplicateValidator(final int duplicatePrice, final int duplicateType,
			final int duplicateQuantity) {
		ErrorCodes retVal = null;

		if (duplicatePrice > 1) {
			retVal = ErrorCodes.DUPLICATEPRICE;
		}
		if (duplicateType > 1) {
			retVal = ErrorCodes.DUPLICATETYPE;
		}
		if (duplicateQuantity > 1) {
			retVal = ErrorCodes.DUPLICATEQUANTITY;
		}
		return retVal;
	}

	/**
	 * Sets the key value pairs.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void setKeyValuePairs(final String key, final String value) {

		inputValueHashMap.put(key, value);
	}

	/**
	 * Key Value Checker.
	 *
	 * @return HashMap with key as fields and value is their respective values
	 *         given by the user in the input
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it.
	 */
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

	/**
	 * Try parse double.
	 *
	 * @param value
	 *            the value
	 * @return boolean result true if parameter value is parsable in int or
	 *         double else it will return false
	 */
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

	/**
	 * Try parse integer.
	 *
	 * @param value
	 *            the value
	 * @return true, if successful
	 */
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

	/**
	 * Item value validator.
	 *
	 * @return Object of Item Details Class which is accessed in the main to
	 *         show the final output
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
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
	}
}