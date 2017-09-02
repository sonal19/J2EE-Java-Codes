/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.imageutility.exceptions;

import org.apache.log4j.spi.ErrorCode;

/**
 * Enum for Storing the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-103
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	/** The mailsend to the user have some error. */
	MAILSEND(210),

	/** The loginsuccess is for if login is not successful. */
	LOGINSUCCESS(211),

	/**
	 * The notauthorized if the username and password doesn't match in the
	 * database.
	 */
	NOTAUTHORIZED(410),

	/** The noresource is if nothing is found or database return nothing. */
	NORESOURCE(404),

	/** The notacceptable is not accepted error. */
	NOTACCEPTABLE(406),

	/** The servererror is error in the server due to some technical reason. */
	SERVERERROR(500),

	/** The serverbusy is whe the server is busy. */
	SERVERBUSY(503),

	/** The unknownerror is the error when the source of error is not known. */
	UNKNOWNERROR(520),

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
