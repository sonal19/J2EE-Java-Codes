package com.nagarro.hibernate.flightdemo.presentation;

import java.util.Locale;
import java.util.ResourceBundle;

import com.nagarro.hibernate.flightdemo.constants.Constants;

/**
 * The Class ConsoleView gives the console output after getting the information
 * from the properties file.It is basically use for user interaction and for the
 * Convenient for user
 */
public class ConsoleView {

	/**
	 * Gets the message from the properties file corresponding to the matched
	 * key.
	 *
	 * @param key
	 *            the key is the matching key which binds the message with it
	 * @return the message in the console
	 */
	public static String getMessage(final String key) {

		final ResourceBundle labels = ResourceBundle.getBundle(Constants.RESOURCE_PATH + "ConsoleMessages",
				Locale.ENGLISH);

		// get the Message from properties file
		final String value = labels.getString(key);

		return value;
	}

}
