package com.example.service.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(ServiceCustomersSuite.class)
public class ServiceCustomersApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceCustomersApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
