package com.nagarro.spring.flightdemo.repository;

import java.util.List;

import com.nagarro.spring.flightdemo.bean.FlightDetail;

public interface FlightDetailsRepositoryCustom {

	public List<FlightDetail> limitEntry();
	public void deleteEntry(String data);
}
