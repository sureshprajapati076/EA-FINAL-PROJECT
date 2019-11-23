package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comments {

    @Id
    private Integer id;
    private Integer apartmentId;
    private String emailId;
    private String comment;
    private int stars;
   
    private List<Replies> replies=new ArrayList<Replies>();
    
    
    public void addReply(Replies reply) {
    	replies.add(reply);
    }


	public Comments() {
		super();
	}


	public Comments(Integer id, Integer apartmentId, String emailId, String comment, int stars) {
		super();
		this.id = id;
		this.apartmentId=apartmentId;
		this.emailId = emailId;
		this.comment = comment;
		this.stars = stars;
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
