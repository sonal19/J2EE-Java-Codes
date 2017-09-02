/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.domain;

/**
 * Class to calculate Tax and total price for Manufactured Items.
 *
 * @author ricktamkundu
 */
public class ManufacturedItemType extends AbstractItemsDetails {

	/**
	 * Instantiates a new manufactured item type.
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
	public ManufacturedItemType(final String itemType, final String itemName, final double itemPrice,
			final int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate the tax for the item.
	 *
	 * @return the double
	 */
	public double calculateTax() {
		final double taxPart = (TaxRates.MANUFACTUREDTAX.taxValue / 100) * getItemPrice();
		final double addedTaxPart = (TaxRates.ADDEDMANUFACTUREDTAX.taxValue / 100) * taxPart;
		final double totalTax = taxPart + addedTaxPart;
		return totalTax;
		// TODO Auto-generated method stub

	}

	/**
	 * Calculate the total price of the item.
	 *
	 * @return it return the double value of the total output price
	 */
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		final double totalPrice = (calculateTax() + getItemPrice()) * getItemQuantity();

		return totalPrice;
	}

}
