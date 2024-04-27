package com.example.service.catalog.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.ntr1x.common.events.model.CloudEventRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.net.URI;

@Configuration
public class ServiceCatalogExchange {
    
    @Bean
    public NewTopic publicCategoryTopic() {
        return TopicBuilder
                .name("public_category")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic publicProductTopic() {
        return TopicBuilder
                .name("public_product")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
