package com.nagarro.spring.flightdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.filters.FlushableGZIPOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.spring.flightdemo.bean.FlightDetail;
import com.nagarro.spring.flightdemo.repository.FlightDetailsRepository;

@Controller
public class FlightController {

	private String name;
	private String image;
	
	@Autowired
	FlightDetailsRepository fdr;

	@RequestMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe");
		FlightDetail fd = new FlightDetail();
		fd.setArrLoc("del");
		fd.setFlightId(321);
		fd.setDepLoc("BLR");
		fd.setFlightClass("E");
		fdr.save(fd);

		model.addAttribute("flightnum", "ok");
		return "welcome";
	}

	@RequestMapping("/login")
	public String register_login(Model model) {

		return "register_login";
	}

	@RequestMapping("/search")
	public String flightSearch(@RequestParam("name") String name, @RequestParam("image") String image, Model model) {
		this.name=name;
		this.image=image;
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", fdr.findAll());
		return "flightSearch";
	}

	@RequestMapping("/adminLogin")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		String retVal = null;

		if (username.equals("admin") && password.equals("admin")) {
			name="admin";
			image="http://images4.fanpop.com/image/photos/22100000/The-letter-A-the-alphabet-22186936-2560-2560.jpg";
			retVal = "redirect:/addFlight?name="+name+"&image="+image;
		} else {
			retVal = "redirect:/login";
		}
		return retVal;
	}

	@RequestMapping("/addFlight")
	public String flightAddAdmin(@RequestParam("name") String name, @RequestParam("image") String image, Model model) {
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", fdr.findAll());
		return "flightAddAdmin";
	}

	@RequestMapping(value = "/uploadFlight", method = RequestMethod.GET)
	public String uploadFlight(Model model) {

		return "uploadFlight";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/displayFlight", method = RequestMethod.GET)
	public String flightDisplay(@RequestParam("depLoc") String depLoc, @RequestParam("arrLoc") String arrLoc,
			@RequestParam("validTill") String validTill, @RequestParam("flightClass") String flightClass, Model model) {
		/*
		 * Criteria criteria = new Criteria();
		 * criteria.orOperator(Criteria.where("arrLoc").is(arrLoc)); Query query
		 * = new Query(criteria);
		 */
		// System.out.println(dep+" "+arr+" "+date+" "+classList);
		List<FlightDetail> flightDetail = fdr.findAll();
		List flightShow = new ArrayList<>();

		/*for (FlightDetail flightObj : flightDetail) {
			if (flightObj.getValidTill().compareTo(validTill) > 0) {
				if (flightObj.getArrLoc().equalsIgnoreCase(arrLoc) && flightObj.getDepLoc().equalsIgnoreCase(depLoc)
						&& flightObj.getFlightClass().contains(flightClass)) {
					flightShow.add(flightObj);
				}
			}

		}*/
		//model.addAttribute("flightSearch", flightShow);
		model.addAttribute("flightSearch", flightDetail);
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		return "flightSearch";
	}
}
