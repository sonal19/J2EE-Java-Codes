package net.viralpatel.spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.viralpatel.spring.codes.FlightDetail;

public interface FlightDetailsRepository extends MongoRepository<FlightDetail, String> {
	

}
