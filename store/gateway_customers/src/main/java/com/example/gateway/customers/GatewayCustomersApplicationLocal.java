package com.example.gateway.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(GatewayCustomersSuite.class)
public class GatewayCustomersApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GatewayCustomersApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
