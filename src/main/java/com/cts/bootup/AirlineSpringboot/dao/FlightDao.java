package com.cts.bootup.AirlineSpringboot.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bootup.AirlineSpringboot.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {

	public List<Flight> findByFlightDateAndOriginAndDestination(LocalDate flightDate, String origin,
			String destination);

	public Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime);
	
	

}
