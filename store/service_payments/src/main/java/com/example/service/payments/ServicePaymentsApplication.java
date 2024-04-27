package com.example.service.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServicePaymentsSuite.class)
public class ServicePaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePaymentsApplication.class, args);
    }
}
