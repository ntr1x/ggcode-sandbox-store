package com.example.service.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Use this main class to launch the application locally.
 */
@SpringBootApplication
@Import(ServiceCatalogSuite.class)
public class ServiceCatalogApplicationLocal {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceCatalogApplicationLocal.class);
        application.setAdditionalProfiles("local");
        application.run(args);
    }
}
