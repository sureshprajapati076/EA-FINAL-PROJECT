package com.example.booking.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bookings {

	@Id
	private int id;
	private String user_id;
	private int apt_id;
	private String unit_number;
	private double unit_price;
	private LocalDate start_date;
	private LocalDate end_date;
	public Bookings() {
		super();
	}
	public Bookings(int id, String user_id, int apt_id, String unit_number, double unit_price, LocalDate start_date,
			LocalDate end_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.apt_id = apt_id;
		this.unit_number = unit_number;
		this.unit_price = unit_price;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getApt_id() {
		return apt_id;
	}
	public void setApt_id(int apt_id) {
		this.apt_id = apt_id;
	}
	public String getUnit_number() {
		return unit_number;
	}
	public void setUnit_number(String unit_number) {
		this.unit_number = unit_number;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "Bookings [id=" + id + ", user_id=" + user_id + ", apt_id=" + apt_id + ", unit_number=" + unit_number
				+ ", unit_price=" + unit_price + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
	

}
