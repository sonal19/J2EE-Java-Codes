/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.constant;

/**
 * Storing the constant value for input and output.
 *
 * @author ricktamkundu
 */
public class Constants {

	/*
	 * Name of fields that should be used in the string given by user for input
	 * an output
	 */

	/** The Constant NAME_OF_ITEM. */
	public static final String NAME_OF_ITEM = "name";

	/** The Constant TYPE_OF_ITEM. */
	public static final String TYPE_OF_ITEM = "type";

	/** The Constant PRICE_OF_ITEM. */
	public static final String PRICE_OF_ITEM = "price";

	/** The Constant QUANTITY_OF_ITEM. */
	public static final String QUANTITY_OF_ITEM = "quantity";

	/** The Constant CONSOLE_OUTPUT. */
	public static final String CONSOLE_OUTPUT = " Item Name : %s \n Item Price : %f \n Item Type : %s \n Item Quantity : %d \n Item Tax : %f \n Item Total Cost : %f \n";

	/** The Constant INPUT_STYLE. */
	public static final String INPUT_STYLE = "Enter the Name of Item, Type of Item, Price of Item, Quantity of Item..\n"
			+ "e.g.- -%s ItemName -%s ItemType -%s ItemPrice -%s ItemQuantity\n"
			+ "ItemType can be of Three Type- raw,imported,manufactured and it is mandatory, "
			+ "ItemName(hyphen is not allowed between name) should be the first element\nin the input string,"
			+ " Type, Price and Quantity can be in any order, there should be "
			+ "at least one space between all four fields. \nEnter:  ";
}
