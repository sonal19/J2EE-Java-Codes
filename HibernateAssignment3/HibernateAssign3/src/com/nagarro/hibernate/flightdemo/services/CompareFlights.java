package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.domain.SearchFlights;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;

/**
 * The Class CompareFlights will compare the details between the all flights
 * details and the flight wanted and finds the required best possible flights
 * available.
 * 
 * @author ricktamkundu
 */
public class CompareFlights {

	/** The search flights. */
	private SearchFlights searchFlights;

	/**
	 * Comparer.
	 *
	 * @return the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<FlightDetails> flightSearch() {

		ArrayList<FlightDetails> availFlightsList = new ArrayList<FlightDetails>();
		Session session = null;
		Transaction transaction = null;

		try {
			session = DataManager.sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query query = session.createQuery(Constants.SEARCH_QUERY);
			query.setString(0, searchFlights.getArrLoc());
			query.setString(1, searchFlights.getDepLoc());
			query.setDate(2, searchFlights.getFlightDate());
			query.setString(3, "Y");
			availFlightsList = (ArrayList<FlightDetails>) query.list();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
		}

		return availFlightsList;

	}

	/**
	 * Sort flights.
	 *
	 * @param availFlightsList
	 *            the avail flights list
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	public void sortFlights(final ArrayList<FlightDetails> availFlightsList) throws UserExceptionClass {

		Collections.sort(availFlightsList, new Comparator<FlightDetails>() {
			/**
			 * Overrides compare method of collection.sort class which is used
			 * to compare two flight details and return the status of the result
			 * 
			 * @return integer value which gives the comparision status
			 */
			@Override
			public int compare(final FlightDetails object1, final FlightDetails object2) {
				final int fareComp = Double.compare(object1.getFare(), object2.getFare());
				if (searchFlights.getSortedBy().equalsIgnoreCase("both")) {
					if (fareComp != 0) {
						return fareComp;
					}
					final int durComp = Double.compare(object1.getFlightDuration(), object2.getFlightDuration());
					return durComp;
				}
				return fareComp;
			}
		});

	}

	/**
	 * Gets the search flights.
	 *
	 * @return the search flights Object
	 */
	public SearchFlights getSearchFlights() {
		return searchFlights;
	}

	/**
	 * Sets the search flights.
	 *
	 * @param searchFlights
	 *            the new search flights
	 */
	public void setSearchFlights(final SearchFlights searchFlights) {
		this.searchFlights = searchFlights;
	}

}

/*
 * if(searchFlights.getSortedBy().equalsIgnoreCase("fare")){ final Query query =
 * session.createQuery(
 * "FROM FlightDetails WHERE Arrival_Location = ? AND  Departure_Location = ? AND Valid_Till > ?  AND Seat_Availibility=? ORDER BY"
 * + "Fare"); query.setString(0, searchFlights.getArrLoc()); query.setString(1,
 * searchFlights.getDepLoc()); query.setDate(2, searchFlights.getFlightDate());
 * query.setString(3, "Y");
 * 
 * availFlightsList = (ArrayList<FlightDetails>) query.list(); } else
 * if(searchFlights.getSortedBy().equalsIgnoreCase("both")){ final Query query =
 * session.createQuery(
 * "FROM FlightDetails WHERE Arrival_Location = ? AND  Departure_Location = ? AND Valid_Till > ?  AND Seat_Availibility=?"
 * + "ORDER BY Flight_Duration,ORDER BY Fare"); query.setString(0,
 * searchFlights.getArrLoc()); query.setString(1, searchFlights.getDepLoc());
 * query.setDate(2, searchFlights.getFlightDate()); query.setString(3, "Y");
 * 
 * availFlightsList = (ArrayList<FlightDetails>) query.list(); }
 */