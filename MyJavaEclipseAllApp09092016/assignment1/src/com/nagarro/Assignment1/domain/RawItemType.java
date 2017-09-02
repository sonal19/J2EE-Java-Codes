/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.domain;

/**
 * Class to calculate Tax and total price for Raw Items.
 *
 * @author ricktamkundu
 */
public class RawItemType extends AbstractItemsDetails {

	/**
	 * Instantiates a new raw item type.
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
	public RawItemType(final String itemType, final String itemName, final double itemPrice, final int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate the tax for the item.
	 *
	 * @return the double
	 */
	public double calculateTax() {
		// TODO Auto-generated method stub
		final double totalTax = (TaxRates.RAWTAX.taxValue / 100) * getItemPrice();
		return totalTax;
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
