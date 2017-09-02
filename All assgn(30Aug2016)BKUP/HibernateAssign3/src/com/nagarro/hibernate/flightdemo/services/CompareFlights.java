package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetail;
import com.nagarro.hibernate.flightdemo.domain.SearchFlight;
import com.nagarro.hibernate.flightdemo.exception.ErrorCodes;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;

/**
 * The Class CompareFlights will compare the details between the all flights
 * details and the flight wanted and finds the required best possible flights
 * available.
 * 
 * @author ricktamkundu
 */
public class CompareFlights {

	/**
	 * The search flights.It is the object which is used for mapping the user
	 * input and provide the implementation
	 */
	private SearchFlight searchFlights;

	/**
	 * Flight Search provides the search results after the user provides the
	 * search criteria.
	 *
	 * @return the array list which contains the result of the flights
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList flightSearch() throws UserExceptionClass {

		ArrayList availFlightsList = new ArrayList();
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
			availFlightsList = (ArrayList<FlightDetail>) query.list();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}

		return availFlightsList;

	}

	/**
	 * Sort flights on the basis or fare or duration or both.
	 *
	 * @param availFlightsList
	 *            the avail flights list
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void sortFlights(final ArrayList availFlightsList) throws UserExceptionClass {

		Collections.sort(availFlightsList, new Comparator<FlightDetail>() {
			/**
			 * Overrides compare method of collection.sort class which is used
			 * to compare two flight details and return the status of the result
			 * 
			 * @return integer value which gives the comparision status
			 */
			@Override
			public int compare(final FlightDetail object1, final FlightDetail object2) {
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
	public SearchFlight getSearchFlights() {
		return searchFlights;
	}

	/**
	 * Sets the search flights.
	 *
	 * @param searchFlights
	 *            the new search flights
	 */
	public void setSearchFlights(final SearchFlight searchFlights) {
		this.searchFlights = searchFlights;
	}

}
