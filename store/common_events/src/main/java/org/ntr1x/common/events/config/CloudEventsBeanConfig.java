package org.ntr1x.common.events.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import org.ntr1x.common.events.CloudEventsConstants;
import org.ntr1x.common.events.annotation.EventAspect;
import org.ntr1x.common.events.model.CloudEventTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class CloudEventsBeanConfig {
    @Autowired
    @Qualifier(CloudEventsConstants.KAFKA_TEMPLATE_CLOUD_EVENT)
    private KafkaTemplate<String, CloudEvent> cloudEventKafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public EventAspect eventAspect() {
        return new EventAspect();
    }

    @Bean
    public CloudEventTemplate cloudEventTemplate() {
        return CloudEventTemplate
                .builder()
                .objectMapper(objectMapper)
                .kafkaTemplate(cloudEventKafkaTemplate)
                .build();
    }
}
