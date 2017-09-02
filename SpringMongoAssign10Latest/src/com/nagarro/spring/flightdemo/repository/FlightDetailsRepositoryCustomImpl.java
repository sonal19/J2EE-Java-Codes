package com.nagarro.spring.flightdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.nagarro.spring.flightdemo.bean.FlightDetail;

public class FlightDetailsRepositoryCustomImpl implements FlightDetailsRepositoryCustom {
	@Autowired private MongoTemplate mongotemp;
	@Autowired FlightDetailsRepository mongofifa;
	
	public List<FlightDetail> limitEntry( ) {
		// TODO Auto-generated method stub
		return mongotemp.find(new Query().with(new Sort(new Order(Direction.DESC,"flightNum"))), FlightDetail.class); 
		
	}
	public void deleteEntry(String date){
		System.out.println(mongofifa.findOne(date));
		//mongotemp.remove(mongofifa.findBydate(date));
	}
}
