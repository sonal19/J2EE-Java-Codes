package com.nagarro.datastorage.presentation;

import com.nagarro.datastorage.dao.DatabaseConn;
import com.nagarro.datastorage.services.CreateTable;
import com.nagarro.datastorage.services.InsertData;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("WELCOEME");
		CreateTable.createTable();
		InsertData.insertFlightData();
		DatabaseConn.accessDatabase("SELECT * FROM Flight_Details");
	}

}
