package com.example.service.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceBasketSuite.class)
public class ServiceBasketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBasketApplication.class, args);
    }
}
