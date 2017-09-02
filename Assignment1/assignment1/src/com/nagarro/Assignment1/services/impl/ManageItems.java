/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.services.impl;

import java.util.HashMap;

import com.nagarro.Assignment1.constant.Constants;
import com.nagarro.Assignment1.domain.ImportedItemType;
import com.nagarro.Assignment1.domain.AbstractItemsDetails;
import com.nagarro.Assignment1.domain.ManufacturedItemType;
import com.nagarro.Assignment1.domain.RawItemType;
import com.nagarro.Assignment1.exception.UserExceptionClass;
import com.nagarro.Assignment1.exception.ErrorCodes;

/**
 * The Class Manage the Items and its Details.
 * 
 * @author ricktamkundu
 */
public class ManageItems {

	/**
	 * Item tax Manager.
	 *
	 * @param itemHashMapDetails
	 *            the item hash map details
	 * @param itemType
	 *            the item type
	 * @param itemName
	 *            the item name
	 * @param itemQuantity
	 *            the item quantity
	 * @param itemPrice
	 *            the item price
	 * @return the items details
	 * @throws UserExceptionClass
	 *             the user exception class fetch error codes and handle it
	 */
	public static AbstractItemsDetails itemsTaxManager(final HashMap<String, String> itemHashMapDetails,
			final String itemType, final String itemName, final int itemQuantity, final double itemPrice)
			throws UserExceptionClass {
		AbstractItemsDetails returnValue = null;
		// If there is no items in the HashMap
		if (!itemHashMapDetails.isEmpty()) {

			switch (itemHashMapDetails.get(Constants.TYPE_OF_ITEM).toString().toLowerCase()) {
			case "raw":
				final AbstractItemsDetails rawItems = new RawItemType(itemType, itemName, itemPrice, itemQuantity);
				returnValue = rawItems;
				break;

			case "imported":
				final AbstractItemsDetails importedItems = new ImportedItemType(itemType, itemName, itemPrice,
						itemQuantity);
				returnValue = importedItems;
				break;

			case "manufactured":
				final AbstractItemsDetails manufacturedItems = new ManufacturedItemType(itemType, itemName, itemPrice,
						itemQuantity);
				returnValue = manufacturedItems;
				break;

			default:
				throw new UserExceptionClass(ErrorCodes.EMPTYHASHMAP);
			}

		}

		else {
			throw new UserExceptionClass(ErrorCodes.EMPTYHASHMAP);
		}

		return returnValue;
	}
}
