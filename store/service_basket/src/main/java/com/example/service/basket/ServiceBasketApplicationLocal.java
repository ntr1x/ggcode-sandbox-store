package com.example.service.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(ServiceBasketSuite.class)
public class ServiceBasketApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceBasketApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
