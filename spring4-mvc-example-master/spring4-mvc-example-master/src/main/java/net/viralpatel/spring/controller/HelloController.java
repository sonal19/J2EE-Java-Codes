package net.viralpatel.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.viralpatel.spring.codes.FlightDetail;
import net.viralpatel.spring.repo.FlightDetailsRepository;


@Controller
public class HelloController {

	@Autowired
	FlightDetailsRepository fdr;
	
	@RequestMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe");
		FlightDetail fd=new FlightDetail();
		fd.setArrLoc("dsad");
		fd.setFlightId(123);
		fdr.save(fd);

		return "welcome";
	}
}
