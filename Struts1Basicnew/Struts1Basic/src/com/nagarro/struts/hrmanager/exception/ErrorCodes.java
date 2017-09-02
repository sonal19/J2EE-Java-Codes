/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.struts.hrmanager.exception;

import org.apache.log4j.spi.ErrorCode;

/**
 * Enum for Storing the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-104
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	/** The no database is present. */
	NODATABASE(101),

	/** The no table is present. */
	NOTABLE(102),

	/** The duplicate entry is present. */
	DUPLICATE(103),

	/**
	 * The connectionfail is when the connection failure occurs in jdbc
	 * connection.
	 */
	CONNECTIONFAIL(104);

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
