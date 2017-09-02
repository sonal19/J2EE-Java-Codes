package com.nagarro.spring.flightdemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nagarro.spring.flightdemo.bean.FlightDetail;


public interface FlightDetailsRepository extends MongoRepository<FlightDetail, String> {
	
	
	public List<FlightDetail> findBydepLoc(String depLoc);
	public List<FlightDetail> findByarrLoc(String arrLoc);
	public List<FlightDetail> findByvalidTill(String validTill);
	public List<FlightDetail> findByflightClass(String flightClass);
	
}
