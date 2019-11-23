package edu.mum.cs.paymentservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("payment")
@RefreshScope
public class PaymentConfig {
    private HashMap<String, String> paymentMethods;

    public HashMap<String, String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(HashMap<String, String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
