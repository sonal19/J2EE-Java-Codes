package com.nagarro.datastorage.services;

import com.nagarro.datastorage.dao.DatabaseConn;

public class CreateTable {

	public static void createTable() {
		final String query = "CREATE TABLE Flight_Details(FlightNumber VARCHAR(40) NOT NULL, DepartureLocation VARCHAR(10) "
				+ "NOT NULL, ArrivalLocation VARCHAR(10) NOT NULL, ValidTill VARCHAR(200), FlightTime VARCHAR(10), FlightDuration double, "
				+ "Fare double, SeatAvailability VARCHAR(2), Class VARCHAR(2))";
		DatabaseConn.accessDatabase(query);
	}
}
