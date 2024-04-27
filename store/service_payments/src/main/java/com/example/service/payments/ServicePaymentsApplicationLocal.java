package com.example.service.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(ServicePaymentsSuite.class)
public class ServicePaymentsApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServicePaymentsApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
