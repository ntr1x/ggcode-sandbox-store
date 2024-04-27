package com.example.gateway.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GatewayCustomersSuite.class)
public class GatewayCustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayCustomersApplication.class, args);
    }
}
