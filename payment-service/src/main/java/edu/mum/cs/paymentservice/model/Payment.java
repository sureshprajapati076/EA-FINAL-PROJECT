package edu.mum.cs.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {
    @Id
    private String paymentId;
    private String paymentMethod;
    private String userId;
    private String price;

    public String getPaymentId() {
        return paymentId;
    }

    public Payment(String paymentId, String paymentMethod, String userId, String price) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.userId = userId;
        this.price = price;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
