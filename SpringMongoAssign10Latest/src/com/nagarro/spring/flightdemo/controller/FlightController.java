package com.nagarro.spring.flightdemo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.spring.flightdemo.bean.FlightDetail;
import com.nagarro.spring.flightdemo.repository.FlightDetailsRepository;
import com.nagarro.spring.flightdemo.service.impl.FlightCSVReaderImpl;
import com.nagarro.spring.flightdemo.util.ConvertDateFormat;
import com.nagarro.spring.flightdemo.util.ReadCSVFromStream;

@Controller
public class FlightController {

	private String name;
	private String image;
	private String success;

	@Autowired
	FlightDetailsRepository fdr;

	@RequestMapping("/login")
	public String register_login(final Model model) {

		return "register_login";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/sortFlightNum")
	public String sortFlightNum(final Model model) {

		final List sortByFlNum = new ArrayList();
		sortByFlNum.addAll(fdr.findAll(new Sort(Sort.Direction.DESC, "flightNum")));

		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", sortByFlNum);
		return "flightSearch";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/sortByFare")
	public String sortByFare(final Model model) {

		final List sortByFare = new ArrayList();
		sortByFare.addAll(fdr.findAll(new Sort(Sort.Direction.DESC, "fare")));

		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", sortByFare);
		return "flightSearch";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/sortByDuration")
	public String sortByDuration(final Model model) {

		final List sortByDur = new ArrayList();
		sortByDur.addAll(fdr.findAll(new Sort(Sort.Direction.DESC, "flightDuration")));

		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", sortByDur);
		return "flightSearch";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/sortByTime")
	public String sortByTime(final Model model) {

		final List sortBytme = new ArrayList();
		sortBytme.addAll(fdr.findAll(new Sort(Sort.Direction.DESC, "flightTime")));

		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", sortBytme);
		return "flightSearch";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/sortByValidity")
	public String sortByValidity(final Model model) {

		final List sortByValid = new ArrayList();
		sortByValid.addAll(fdr.findAll(new Sort(Sort.Direction.DESC, "validTill")));

		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", sortByValid);
		return "flightSearch";
	}

	@RequestMapping("/flightUploader")
	public String flightUploader(final Model model) {
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("success", success);
		return "flightUploader";
	}

	@RequestMapping("/search")
	public String flightSearch(@RequestParam("name") final String name, @RequestParam("image") final String image,
			final Model model) {
		this.name = name;
		this.image = image;
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", fdr.findAll());

		return "flightSearch";
	}

	@RequestMapping("/adminLogin")
	public String login(@RequestParam("username") final String username,
			@RequestParam("password") final String password, final Model model) {
		String retVal = null;

		if (username.equals("admin") && password.equals("admin")) {
			name = "admin";
			image = "http://images4.fanpop.com/image/photos/22100000/The-letter-A-the-alphabet-22186936-2560-2560.jpg";
			retVal = "redirect:/addFlight?name=" + name + "&image=" + image;
		} else {
			retVal = "redirect:/login";
		}
		return retVal;
	}

	@RequestMapping("/addFlight")
	public String flightAddAdmin(@RequestParam("name") final String name, @RequestParam("image") final String image,
			final Model model) {
		success = "";
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("flightSearch", fdr.findAll());
		return "flightAddAdmin";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/uploadFlights", method = RequestMethod.POST)
	public @ResponseBody String uploadFlight(@RequestParam("file") final MultipartFile file) {
		System.out.println("HERE");
		if (!file.isEmpty()) {
			try {
				final byte[] bytes = file.getBytes();
				final String fileName = file.getOriginalFilename();
				final int flightCount = fdr.findAll().size();

				final String airwaysName = fileName.replaceAll(".csv", "");
				final FlightCSVReaderImpl csvRdrInstance = FlightCSVReaderImpl.getInstance();
				final List fd = new ArrayList<>(20);
				final File csvFile = ReadCSVFromStream.csvStreamReader(bytes);
				fd.addAll(csvRdrInstance.readCSVFile(csvFile, airwaysName, flightCount));
				fdr.save(fd);
				success = "true";

			} catch (final Exception e) {
				success = "false";
			}
		} else {
			success = "false";
		}
		return "redirect:/flightUploader";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/displayFlight", method = RequestMethod.GET)
	public String flightDisplay(@RequestParam("depLoc") final String depLoc,
			@RequestParam("arrLoc") final String arrLoc, @RequestParam("validTill") String validTill,
			@RequestParam("flightClass") final String flightClass, final Model model) {

		validTill = ConvertDateFormat.convertDateFormat(validTill, "dd-MM-yyyy");

		final List<FlightDetail> flightDetail = fdr.findAll();
		final List flightShow = new ArrayList<>(20);

		for (final FlightDetail flightObj : flightDetail) {
			if (flightObj.getValidTill().equalsIgnoreCase(validTill)) {
				if (flightObj.getArrLoc().equalsIgnoreCase(arrLoc) && flightObj.getDepLoc().equalsIgnoreCase(depLoc)
						&& flightObj.getFlightClass().contains(flightClass)
						&& flightObj.getSeatAvailibility().equalsIgnoreCase("Y")) {
					flightShow.add(flightObj);
				}
			}

		}
		model.addAttribute("depLoc", depLoc);
		model.addAttribute("arrLoc", arrLoc);
		model.addAttribute("validTill", validTill);
		model.addAttribute("flightClass", flightClass);

		model.addAttribute("flightSearch", flightShow);
		// model.addAttribute("flightSearch", flightDetail);
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		model.addAttribute("afterSearch", "true");
		return "flightSearch";
	}
}
