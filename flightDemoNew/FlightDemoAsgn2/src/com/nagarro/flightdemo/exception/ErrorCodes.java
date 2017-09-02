/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.flightdemo.exception;

import org.apache.log4j.spi.ErrorCode;

/**
 * Enum for Stroring the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-103
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	/** The emptyinput. */
	EMPTYINPUT(101),
	/** The inputwrong. */
	INPUTWRONG(102),
	/** The No Flights. */
	NOFLIGHTS(103),
	/** The nofile. */
	NOFILE(104);

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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return errorCodes;
	}

}
