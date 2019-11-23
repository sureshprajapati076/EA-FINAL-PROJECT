package edu.mum.cs.paymentservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.mum.cs.paymentservice.config.PaymentConfig;
import edu.mum.cs.paymentservice.feign.PaymentFeign;
import edu.mum.cs.paymentservice.model.Payment;
import edu.mum.cs.paymentservice.repository.PaymentRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RefreshScope
public class PaymentController {
    @Autowired
    private PaymentFeign paymentFeign;
    @Autowired
    private PaymentConfig paymentConfig;
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payment/methods")
    @ApiOperation(value = "Gives the available payment methods.")
    public Set<String> paymentMethods() {
        return paymentConfig.getPaymentMethods().keySet();
    }

    @PostMapping("/makePayment/{method}")
    @ApiOperation(value = "Makes a payment and gets redirect url from gateway")
    @HystrixCommand(fallbackMethod = "makePaymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
    public Map<String, Object> makePayment(@ApiParam(value = "The name of payment method", required = true) @PathVariable String method, @RequestBody Payment payment) {
        String paymentServiceUrl = paymentConfig.getPaymentMethods().get(method);
        URI serviceUri = URI.create(paymentServiceUrl);
        Map<String, Object> resp = paymentFeign.makePayment(serviceUri, payment);
        return resp;
    }

    @PostMapping("/completePayment/{method}")
    @ApiOperation(value = "Completes payment and returns paymentId")
    @HystrixCommand(fallbackMethod = "completePaymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
    public Map<String, Object> completePayment(@PathVariable String method, @RequestBody Map<String, Object> data) {
        String paymentServiceUrl = paymentConfig.getPaymentMethods().get(method);
        URI serviceUri = URI.create(paymentServiceUrl);
        Map<String, Object> resp = paymentFeign.completePayment(serviceUri, data);
//        if(resp.containsKey("status") && resp.get("status").equals("success")) {
//            savePayment((String) resp.get("paymentId"), method, (String) resp.get("userId"), (String) resp.get("price"));
//        }
        return resp;
    }

    private void savePayment(String method, String paymentId, String userId, String price) {
        Payment payment = new Payment(paymentId, method, userId, price);
        paymentRepository.save(payment);
        System.out.println("Payment saved successfully");
    }

    public Map<String, Object> makePaymentFallback(@PathVariable String method, @RequestBody Payment payment, Throwable throwable) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("status", "failed");
        resp.put("message", "Error. Cannot make payment.");
        return resp;
    }

    public Map<String, Object> completePaymentFallback(@PathVariable String method, @RequestBody Map<String, Object> data) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("status", "failed");
        resp.put("message", "Error. Cannot complete payment.");
        return resp;
    }
}
