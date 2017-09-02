/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.domain;

/**
 * Abstract class to store the AbstractItemsDetails with calculate tax and total
 * price as its functionality.
 *
 * @author ricktamkundu
 */
public abstract class AbstractItemsDetails {

	/** The item type. */
	private String itemType;

	/** The item name. */
	private String itemName;

	/** The item price. */
	private double itemPrice;

	/** The item quantity. */
	private int itemQuantity;

	/**
	 * Instantiates a new items details.
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
	public AbstractItemsDetails(final String itemType, final String itemName, final double itemPrice,
			final int itemQuantity) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemQuantity = itemQuantity;
	}

	/**
	 * Gets the item type.
	 *
	 * @return type of item
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * Sets the item type.
	 *
	 * @param itemType
	 *            the new item type
	 */
	public void setItemType(final String itemType) {
		this.itemType = itemType;
	}

	/**
	 * Gets the item name.
	 *
	 * @return name of item
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the new item name
	 */
	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item price.
	 *
	 * @return price of item
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice
	 *            the new item price
	 */
	public void setItemPrice(final double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return Quantity of Item
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 *
	 * @param itemQuantity
	 *            the new item quantity
	 */
	public void setItemQuantity(final int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * Calculate tax.
	 *
	 * @return the double
	 */
	public abstract double calculateTax();

	/**
	 * Calculate total price.
	 *
	 * @return the double
	 */
	public abstract double calculateTotalPrice();

}
