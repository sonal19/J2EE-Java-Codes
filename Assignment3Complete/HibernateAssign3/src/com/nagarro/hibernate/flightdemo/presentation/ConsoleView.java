package com.nagarro.hibernate.flightdemo.presentation;

import java.util.Locale;
import java.util.ResourceBundle;

import com.nagarro.hibernate.flightdemo.constants.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsoleView.
 */
public class ConsoleView {

	/**
	 * Gets the message.
	 *
	 * @param key
	 *            the key
	 * @return the message
	 */
	public static String getMessage(final String key) {

		final ResourceBundle labels = ResourceBundle.getBundle(Constants.RESOURCE_PATH + "ConsoleMessages",
				Locale.ENGLISH);

		// get the Message from properties file
		final String value = labels.getString(key);

		return value;
	}

}
