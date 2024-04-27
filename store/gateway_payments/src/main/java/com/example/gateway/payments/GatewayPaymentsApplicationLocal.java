package com.example.gateway.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(GatewayPaymentsSuite.class)
public class GatewayPaymentsApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GatewayPaymentsApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
