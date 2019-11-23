package com.example.demo.model;

public class Replies {
	private String reply;
	private String email;
	public String getComment() {
		return reply;
	}
	public void setComment(String comment) {
		this.reply = comment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Replies() {}
	public Replies(String comment, String email) {
		super();
		this.reply = comment;
		this.email = email;
	}

}
