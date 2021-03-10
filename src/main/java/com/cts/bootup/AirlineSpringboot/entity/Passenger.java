package com.cts.bootup.AirlineSpringboot.entity;

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

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@Column(name="passenger_id")
	private int id;
	
	@Column(name="email_address")
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="booking_details",
				joinColumns = {@JoinColumn(name="passenger_id", referencedColumnName = "passenger_id")},
				inverseJoinColumns = {@JoinColumn(name="booking_id",referencedColumnName = "booking_id")}
			    )
	private List<BookingRecord> bookingRecord;
	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@Column(name="booking_id")
//	public BookingRecord bookingRecord1;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public List<BookingRecord> getBookingRecord() {
		return bookingRecord;
	}


	public void setBookingRecord(List<BookingRecord> bookingRecord) {
		this.bookingRecord = bookingRecord;
	}
	
	
	
	
	
	
	

}
