package edu.mum.cs.paypalservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("paypal")
@RefreshScope
public class PaypalConfig {
    private HashMap<String, String> redirectUrls;

    public HashMap<String, String> getRedirectUrls() {
        return redirectUrls;
    }

    public void setRedirectUrls(HashMap<String, String> redirectUrls) {
        this.redirectUrls = redirectUrls;
    }
}
