package com.example.service.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(ServiceEventsSuite.class)
public class ServiceEventsApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceEventsApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
