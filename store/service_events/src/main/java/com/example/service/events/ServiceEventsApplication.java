package com.example.service.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceEventsSuite.class)
public class ServiceEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEventsApplication.class, args);
    }
}
