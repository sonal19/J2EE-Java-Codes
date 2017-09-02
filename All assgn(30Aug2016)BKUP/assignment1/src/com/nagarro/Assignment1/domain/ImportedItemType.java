/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.domain;

/**
 * Class to calculate Tax and total price for Imported Items.
 *
 * @author ricktamkundu
 */
public class ImportedItemType extends AbstractItemsDetails {

	/** The surcharge. */
	private transient double surcharge;

	/**
	 * Instantiates a new imported item type.
	 *
	 * @param itemType
	 *            the item type
	 * @param itemName
	 *            the item name
	 * @param itemPrice
	 *            the item price
	 * @param itemQuantity
	 *            the item quantity
	 */
	public ImportedItemType(final String itemType, final String itemName, final double itemPrice,
			final int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);

	}

	/**
	 * Calculate the tax for the item.
	 *
	 * @return the double
	 */
	public double calculateTax() {

		final double totalTax = (TaxRates.IMPORTEDTAX.taxValue / 100) * getItemPrice();
		if ((totalTax + getItemPrice()) <= 100) {
			surcharge = 5;
		} else if ((totalTax + getItemPrice()) > 100 && (totalTax + getItemPrice()) <= 200) {
			surcharge = 10;
		} else {
			surcharge = (5 / 100) * (totalTax + getItemPrice());
		}
		return totalTax;

	}

	/**
	 * Calculate the total price of the item.
	 *
	 * @return it return the double value of the total output price
	 */
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		final double totalPrice = (calculateTax() + getItemPrice() + surcharge) * getItemQuantity();

		return totalPrice;
	}

}
