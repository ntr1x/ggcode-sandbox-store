package com.example.service.payments.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.ntr1x.common.events.model.CloudEventRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.net.URI;

@Configuration
public class ServicePaymentsExchange {
    
    @Bean
    public NewTopic publicOrderTopic() {
        return TopicBuilder
                .name("public_order")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic publicPaymentTopic() {
        return TopicBuilder
                .name("public_payment")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
