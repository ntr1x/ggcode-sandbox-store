package com.example.service.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceCustomersSuite.class)
public class ServiceCustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomersApplication.class, args);
    }
}
