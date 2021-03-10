package com.cts.bootup.AirlineSpringboot.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking_record")
public class BookingRecord {
	
	@Id
	@Column(name="booking_id")
	private int id;
	
	@Column(name= "booking_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	
	
	@Column(name= "destination")
	private String destination;
	
	@Column(name= "fare")
	private int fare;
	
	@Column(name= "flight_date")
	@Temporal(TemporalType.DATE)
	private Date flightDate;
	
	@Column(name= "flight_number")
	private String flightNumber;
	
	@Column(name= "flight_time")
	@Temporal(TemporalType.TIME)
	private Date flightTime;
	
	@Column(name= "origin")
	private String origin;
	
	@Column(name= "status")
	private String status;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="booking_details",
			inverseJoinColumns = {@JoinColumn(name="passenger_id", referencedColumnName = "passenger_id")},
			joinColumns = {@JoinColumn(name="booking_id",referencedColumnName = "booking_id")}
		    )
	private List<Passenger> passengers;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public Date getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public Date getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
	
	
}