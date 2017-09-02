/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.exception;

import org.apache.log4j.spi.ErrorCode;

/**
 * Enum for Stroring the Error Codes used for User exception Handling. Error
 * codes are stored as number format from 101-115
 *
 * @author ricktamkundu
 */
public enum ErrorCodes implements ErrorCode {

	/** The wrongtype. */
	WRONGTYPE(101),
	/** The mandatoryname. */
	MANDATORYNAME(102),
	/** The emptyinput. */
	EMPTYINPUT(103),
	/** The firstinputname. */
	FIRSTINPUTNAME(104),
	/** The emptyname. */
	EMPTYNAME(105),

	/** The emptytype. */
	EMPTYTYPE(106),
	/** The emptyquantity. */
	EMPTYQUANTITY(107),
	/** The emptyprice. */
	EMPTYPRICE(108),
	/** The notavailabletypes. */
	NOTAVAILABLETYPES(109),

	/** The emptyhashmap. */
	EMPTYHASHMAP(110),
	/** The inputwrong. */
	INPUTWRONG(111),
	/** The duplicatename. */
	DUPLICATENAME(112),
	/** The duplicateprice. */
	DUPLICATEPRICE(113),
	/** The duplicatequantity. */
	DUPLICATEQUANTITY(114),
	/** The duplicatetype. */
	DUPLICATETYPE(115);

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
