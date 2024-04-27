package com.example.gateway.customers.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.ntr1x.common.events.model.CloudEventRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.net.URI;

@Configuration
public class GatewayCustomersExchange {
    
    @Bean
    public NewTopic publicCustomersTopic() {
        return TopicBuilder
                .name("public_customers")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic verifyPhoneTopic() {
        return TopicBuilder
                .name("verify_phone")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic verifyEmailTopic() {
        return TopicBuilder
                .name("verify_email")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic updatePhoneTopic() {
        return TopicBuilder
                .name("update_phone")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic updateEmailTopic() {
        return TopicBuilder
                .name("update_email")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
