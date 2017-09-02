package com.nagarro.hibernate.flightdemo.presentation;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hibernate.flightdemo.dto.FlightDetails;
import com.nagarro.hibernate.flightdemo.services.FilterCSVFile;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("WELCOEME");
		
		FlightDetails flightDetails=new FlightDetails();
		
		final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		flightList.addAll(FilterCSVFile.filterCSVFile("."));
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		for(FlightDetails flightObject:flightList){
		flightDetails.setFlightNum(flightObject.getFlightNum());
		flightDetails.setDepLoc(flightObject.getDepLoc());
		flightDetails.setArrLoc(flightObject.getArrLoc());
		flightDetails.setValidTill(flightObject.getValidTill());
		flightDetails.setFare(flightObject.getFare());
		flightDetails.setFlightClass(flightObject.getFlightClass());
		flightDetails.setSeatAvailibility(flightObject.getSeatAvailibility());
		flightDetails.setFlightTime(flightObject.getFlightTime());
		flightDetails.setFlightDuration(flightObject.getFlightDuration());
		
		try {
			//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(flightDetails);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		}
		
	}

}
