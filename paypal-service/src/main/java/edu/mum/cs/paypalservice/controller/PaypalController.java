package edu.mum.cs.paypalservice.controller;

import edu.mum.cs.paypalservice.model.Payment;
import edu.mum.cs.paypalservice.util.PayPalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PaypalController {
    @Autowired
    private PayPalClient payPalClient;

    @GetMapping("/home")
    public String index() {
        return "This is Paypal service home";
    }

    @GetMapping("/cancelPayment")
    public String cancelPayment() {
        return "The user has Cancelled payment";
    }

    @PostMapping(value = "/makePayment")
    public Map<String, Object> makePayment(@RequestBody Payment payment) {
        String price = payment.getPrice();
        String userId = payment.getUserId();
        return payPalClient.createPayment(userId, price);
    }

    @PostMapping(value = "/completePayment")
    public Map<String, Object> completePayment(@RequestBody Map<String, Object> data) {
        String paymentId = (String) data.get("paymentId");
        String PayerID = (String) data.get("PayerID");
        return payPalClient.completePayment(paymentId, PayerID);
    }
}
