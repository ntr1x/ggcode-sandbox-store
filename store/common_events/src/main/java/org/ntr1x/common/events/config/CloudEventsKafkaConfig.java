package org.ntr1x.common.events.config;

import io.cloudevents.CloudEvent;
import io.cloudevents.kafka.CloudEventDeserializer;
import io.cloudevents.kafka.CloudEventSerializer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.ntr1x.common.events.CloudEventsConstants;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;

@Configuration
@RequiredArgsConstructor
public class CloudEventsKafkaConfig {
    private final KafkaProperties kafkaProperties;

    @Bean(CloudEventsConstants.CONSUMER_FACTORY_CLOUD_EVENT)
    public ConsumerFactory<String, CloudEvent> cloudEventConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(null),
                new StringDeserializer(),
                new CloudEventDeserializer()
        );
    }

    @Bean(CloudEventsConstants.CONTAINER_FACTORY_CLOUD_EVENT)
    public ConcurrentKafkaListenerContainerFactory<String, CloudEvent> cloudEventContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CloudEvent> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(cloudEventConsumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }

    @Bean(CloudEventsConstants.PRODUCER_FACTORY_CLOUD_EVENT)
    public ProducerFactory<String, CloudEvent> cloudEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(
                kafkaProperties.buildProducerProperties(null),
                new StringSerializer(),
                new CloudEventSerializer()
        );
    }

    @Bean(CloudEventsConstants.KAFKA_TEMPLATE_CLOUD_EVENT)
    public KafkaTemplate<String, CloudEvent> cloudEventKafkaTemplate() {
        return new KafkaTemplate<>(cloudEventProducerFactory());
    }
}
