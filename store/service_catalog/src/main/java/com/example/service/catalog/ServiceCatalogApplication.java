package com.example.service.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceCatalogSuite.class)
public class ServiceCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCatalogApplication.class, args);
    }
}
