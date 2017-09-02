/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.services.impl;

import com.nagarro.Assignment1.constant.Constants;
import com.nagarro.Assignment1.domain.AbstractItemsDetails;
import com.nagarro.Assignment1.exception.UserExceptionClass;
import com.nagarro.Assignment1.exception.ErrorCodes;
import com.nagarro.Assignment1.validation.UserInputValidation;

/**
 * The Class ExceptionHandler.I handles all the exception caught by User
 * Exception class and general Exception class.
 */
public class ExceptionHandler {

	/**
	 * Handle exception.
	 */
	public static String handleException() {

		String retOutput = null;
		try {

			final AbstractItemsDetails itemDetails = UserInputValidation.itemValueValidator();
			if (itemDetails == null) {
				throw new UserExceptionClass(ErrorCodes.INPUTWRONG);
			}
			final String output = String.format(Constants.CONSOLE_OUTPUT, itemDetails.getItemName(),
					itemDetails.getItemPrice(), itemDetails.getItemType(), itemDetails.getItemQuantity(),
					itemDetails.calculateTax(), itemDetails.calculateTotalPrice());
			retOutput = output;
			// System.out.println(output);
		} catch (final UserExceptionClass ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			retOutput = UserExceptionClass.getMessage(String.valueOf(ex.errorCodes.getID()));
		} catch (final Exception ex) {
			// TODO: handle exception
			// System.out.println(ex.getMessage());
			retOutput = ex.getMessage();
		}
		return retOutput;

	}

}
