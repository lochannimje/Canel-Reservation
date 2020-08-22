package com.group5.CancelBooking.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group5.CancelBooking.dto.Status;

@Entity
@Table(name="deletebooking")
public class CancelEntity {
	
	@Id
	@Column(name="booking_id",nullable=false)
	
	Integer bookingId;
	@Column(name="date")
	String date;
	@Column(name="source")
	String source;
	@Column(name="dest")
	String dest;
	@Column(name="travel_mode")
	String  travelMode;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	Status status;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getTravelMode() {
		return travelMode;
	}
	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
		
	
}

	



