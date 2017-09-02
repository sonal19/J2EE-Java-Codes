/*
 * Copyright (c) Nagarro. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.nagarro.Assignment1.domain;

/**
 * Enum for business tax rate used for tax calculation.
 *
 * @author ricktamkundu
 */
public enum TaxRates {

	/** The rawtax. */
	RAWTAX(12.5),
	/** The manufacturedtax. */
	MANUFACTUREDTAX(12.5),
	/** The addedmanufacturedtax. */
	ADDEDMANUFACTUREDTAX(2),
	/** The importedtax. */
	IMPORTEDTAX(10);

	/** The tax value. */
	public double taxValue;

	/**
	 * Tax rate can be of double type.
	 *
	 * @param taxValue
	 *            the tax value
	 */
	private TaxRates(final double taxValue) {
		this.taxValue = taxValue;

	}
}
