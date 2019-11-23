package com.example.booking.model;

public class BookingDTO {
	private Bookings booking;
	private String jwt;
	public BookingDTO() {
		super();
	}
	public BookingDTO(Bookings booking, String jwt) {
		super();
		this.booking = booking;
		this.jwt = jwt;
	}
	public Bookings getBooking() {
		return booking;
	}
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	

}
