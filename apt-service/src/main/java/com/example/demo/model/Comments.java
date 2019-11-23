package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Comments {

    private Integer id;
    private Integer apartmentId;
    private String emailId;
    private String comment;
    private int stars;
   
    private List<Replies> replies=new ArrayList<Replies>();
    
  

	public Comments() {
		super();
	}


	public Comments(Integer id, Integer apartmentId, String emailId, String comment, int stars, List<Replies> replies) {
		super();
		this.id = id;
		this.apartmentId = apartmentId;
		this.emailId = emailId;
		this.comment = comment;
		this.stars = stars;
		this.replies = replies;
	}


	


	public Integer getApartmentId() {
		return apartmentId;
	}


	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getStars() {
		return stars;
	}


	public void setStars(int stars) {
		this.stars = stars;
	}


	public List<Replies> getReplies() {
		return replies;
	}


	public void setReplies(List<Replies> replies) {
		this.replies = replies;
	}
    
    
    
    
}
