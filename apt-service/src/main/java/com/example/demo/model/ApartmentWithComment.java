package com.example.demo.model;

import java.util.List;

public class ApartmentWithComment {
	private Apartments apt;
	private List<Comments> comments;
	public ApartmentWithComment() {
		super();
	}
	public ApartmentWithComment(Apartments apt, List<Comments> comments) {
		super();
		this.apt = apt;
		this.comments = comments;
	}
	public Apartments getApt() {
		return apt;
	}
	public void setApt(Apartments apt) {
		this.apt = apt;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	

}
