package com.cts.bootup.AirlineSpringboot.controller;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bootup.AirlineSpringboot.dao.*;
import com.cts.bootup.AirlineSpringboot.entity.*;
import com.cts.bootup.AirlineSpringboot.*;
import com.cts.bootup.AirlineSpringboot.service.*;

@RestController
@RequestMapping("/api/flights")
public class FlightRestController {

	@Autowired
	private SearchFlightServiceImpl sf;
	
	@Autowired
	private FlightDao flightDao;
	

	@RequestMapping("/book")
	public String bookTicket(@RequestParam("flightNumber") String flightNumber) {

		System.out.println("====> " + flightNumber);
		return null;
	}

	@RequestMapping("/listAll")
	public Stream<Flight> listAlls(Model data) {
		Stream<Flight> flights = sf.search(new SearchCriteria(LocalDate.of(2020, 8, 21), "HYDERABAD", "DELHI", 8));
		// data.addAttribute("flights", flights);
		data.addAttribute("flights", (Iterable<Flight>) flights::iterator);

		return flights;
	}
	
	@GetMapping()
	public Stream<Flight> listAll() {
		Stream<Flight> flights = sf.search(new SearchCriteria(LocalDate.of(2020, 8, 21), "HYDERABAD", "DELHI", 8));

		return flights;
	}
	
	@GetMapping("/f1")
	public String f() {
		return "GET Method";
	}
	
	
	@PostMapping()
	public Flight f2(@RequestBody Flight flight) {
		System.out.println(flight.getFlightNumber());
		flightDao.save(flight);
		return flight;
	}
	
	@PutMapping
	public String f3() {
		return "PUT MAPPING DATA /FULL  MODIFICATION";
	}
	
	@DeleteMapping
	public String f4() {
		return "DELETE MAPPING DATA";
	}
	
	@PatchMapping
	public String f5() {
		return "PATCH MAPPING DATA / PARTIAL MODIFICATION";
	}
}
