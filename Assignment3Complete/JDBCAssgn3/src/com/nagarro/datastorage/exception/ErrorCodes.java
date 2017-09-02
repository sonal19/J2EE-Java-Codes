/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.datastorage.exception;

import org.apache.log4j.spi.ErrorCode;

// TODO: Auto-generated Javadoc
/**
 * Enum for Storing the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-103
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	
	/** The nodatabase. */
	NODATABASE(101),

	
	/** The notable. */
	NOTABLE(102),


	/** The duplicate. */
	DUPLICATE(103),

	
	/** The connectionfail. */
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return errorCodes;
	}

}
