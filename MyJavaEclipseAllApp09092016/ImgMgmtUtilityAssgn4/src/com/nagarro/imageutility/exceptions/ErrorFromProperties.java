package com.nagarro.imageutility.exceptions;

import java.util.Locale;
import java.util.ResourceBundle;

import com.nagarro.imageutility.constants.Constants;


/**
 * The Class ErrorFromProperties gives the console output after getting the information
 * from the properties file.It is basically use for user interaction and for the
 * Convenient for user
 */
public class ErrorFromProperties {

	/**
	 * Gets the message from the properties file corresponding to the matched
	 * key.
	 *
	 * @param key
	 *            the key is the matching key which binds the message with it
	 * @return the message in the console
	 */
	public static String getMessage(final String key) {

		final ResourceBundle labels = ResourceBundle.getBundle(Constants.RESOURCE_PATH + "ErrorMessages",
				Locale.ENGLISH);

		// get the Message from properties file
		final String value = labels.getString(key);

		return value;
	}

}
