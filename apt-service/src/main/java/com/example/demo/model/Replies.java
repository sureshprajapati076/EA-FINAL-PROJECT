package com.example.demo.model;

public class Replies {
	private String comment;
	private String email;
	public Replies() {}
	public Replies(String reply, String email) {
		super();
		this.comment = reply;
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String reply) {
		this.comment = reply;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
