/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.hibernate.flightdemo.exception;

import org.apache.log4j.spi.ErrorCode;

/**
 * Enum for Storing the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-103
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	/** The emptyinput.When the user typed nothing in the console */
	EMPTYINPUT(101),

	/** The inputwrong.When user provides the wrong input and violates it */
	INPUTWRONG(102),

	/** The No Flights.If there is no flights available in the given date */
	NOFLIGHTS(103),

	/** The nofile.If there is no file available in the folder to read from */
	NOFILE(104),

	/** The parserror.When parsing from one form to others is wrong */
	PARSERROR(105),

	/**
	 * The session error.When there is any error in open,commit or rollback or
	 * closing the session
	 */
	SESSIONERROR(106);

	/** The error codes. */
	public int errorCodes;

	/**
	 * Instantiates a new error codes.
	 *
	 * @param errorCodes
	 *            the error codes
	 */
	private ErrorCodes(final int errorCodes) {
		this.errorCodes = errorCodes;
	}

	/**
	 * Gets the id of the error codes as provided in the enum.
	 *
	 * @return the id of the given error codes
	 */
	public int getID() {
		return errorCodes;
	}

}
