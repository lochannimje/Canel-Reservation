package com.group5.CancelBooking.dto;

import java.util.Date;

import com.group5.CancelBooking.entity.CancelEntity;

public class CancelDTO {
	
	Integer bookingId;
	String date;
	String source;
	String dest;
	String  travelMode;
	Status status;
	public Integer getBooking_id() {
		return bookingId;
	}
	public void setBooking_id(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getTravel_mode() {
		return travelMode;
	}
	public void setTravel_mode(String travelMode) {
		this.travelMode = travelMode;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public CancelEntity createEntity() {
		// TODO Auto-generated method stub
		CancelEntity booking = new CancelEntity();
		booking.setBookingId(this.getBooking_id());
		booking.setDate(this.getDate());
		booking.setSource(this.getSource());
		booking.setDest(this.getDest());
		booking.setTravelMode(this.getTravel_mode());
		booking.setStatus(this.getStatus());;
		
		return booking;
		
	}
	public static CancelDTO valueOf(CancelEntity booking) {
		// TODO Auto-generated method stub
		CancelDTO bookingDTO=new CancelDTO();
		bookingDTO.setBooking_id(booking.getBookingId());
		bookingDTO.setDate(booking.getDate());
		bookingDTO.setSource(booking.getSource());
		bookingDTO.setDest(booking.getDest());
		bookingDTO.setTravel_mode(booking.getTravelMode());
		bookingDTO.setStatus(booking.getStatus());
		
		return bookingDTO;
	}
	
	

}

