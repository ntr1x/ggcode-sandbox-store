package com.example.gateway.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GatewayPaymentsSuite.class)
public class GatewayPaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayPaymentsApplication.class, args);
    }
}
