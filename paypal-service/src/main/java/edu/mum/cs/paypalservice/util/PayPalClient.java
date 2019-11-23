package edu.mum.cs.paypalservice.util;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import edu.mum.cs.paypalservice.config.PaypalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RefreshScope
public class PayPalClient {
    @Autowired
    private PaypalConfig paypalConfig;

    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.client.secret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;
    private static final String SUCCESS_URL = "http://localhost:8082/home";
    private static final String CANCEL_URL = "http://localhost:8082/cancelPayment";


    public Map<String, Object> createPayment(String userId, String price) {
        Map<String, Object> response = new HashMap<String, Object>();
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(price);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Paypal payment for Apartment booking.");
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(paypalConfig.getRedirectUrls().get("cancel"));
        redirectUrls.setReturnUrl(paypalConfig.getRedirectUrls().get("success"));
        payment.setRedirectUrls(redirectUrls);
        Payment createdPayment;
        try {
            String redirectUrl = "";
            APIContext context = new APIContext(clientId, clientSecret, "sandbox");
            createdPayment = payment.create(context);
            if (createdPayment != null) {
                List<Links> links = createdPayment.getLinks();
                for (Links link : links) {
                    if (link.getRel().equals("approval_url")) {
                        redirectUrl = link.getHref();
                        break;
                    }
                }
                response.put("status", "success");
                response.put("redirect_url", redirectUrl);
            }
        } catch (PayPalRESTException e) {
            System.out.println("Error happened during payment creation!");
            response.put("status", "failed");
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> completePayment(String paymentId, String PayerID){
        Map<String, Object> response = new HashMap();
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(PayerID);
        try {
            APIContext context = new APIContext(clientId, clientSecret, mode);
            Payment createdPayment = payment.execute(context, paymentExecution);
            if(createdPayment!=null){
                response.put("status", "success");
                response.put("payment", createdPayment.getState());
                response.put("paymentId", paymentId);
            }
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
            response.put("status", "failed");
            response.put("message", e.getMessage());
        }
        return response;
    }
}
