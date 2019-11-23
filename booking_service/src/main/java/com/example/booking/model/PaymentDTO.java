package com.example.booking.model;

public class PaymentDTO {
	
    
    private String userId;
    private String price;
    
	public PaymentDTO(String userId, String price) {
		super();
		this.userId = userId;
		this.price = price;
	}
	public PaymentDTO() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    

}
