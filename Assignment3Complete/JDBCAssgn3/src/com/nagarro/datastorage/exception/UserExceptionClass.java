package com.nagarro.datastorage.exception;

import java.util.Locale;
import java.util.ResourceBundle;

import com.nagarro.datastorage.constants.Constants;


// TODO: Auto-generated Javadoc
/**
 * A User Exception class for handling the exception defined externally. It is
 * taking the error codes from properties and get the string using Resource
 * bundle.
 *
 * @author ricktamkundu
 */
public class UserExceptionClass extends Exception {

	/** The error codes. */
	public transient ErrorCodes errorCodes;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor which take string as an input.
	 *
	 * @param errCodes
	 *            the error codes used from properties
	 */
	public UserExceptionClass(final ErrorCodes errCodes) {
		super();
		this.errorCodes = errCodes;
	}

	/**
	 * Gets the message.
	 *
	 * @param key
	 *            the key
	 * @return the message
	 */
	public static String getMessage(final String key) {

		final ResourceBundle labels = ResourceBundle
				.getBundle(Constants.RESOURCE_PATH+"ErrorMessages", Locale.ENGLISH);

		// get the Message from properties file
		final String value = labels.getString(key);

		return value;
	}
}
