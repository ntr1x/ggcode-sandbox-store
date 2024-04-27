package org.ntr1x.common.events.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import lombok.Builder;
import org.springframework.kafka.core.KafkaTemplate;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@Builder(toBuilder = true)
public class CloudEventTemplate {
    private ObjectMapper objectMapper;
    private String topic;
    private String type;
    private URI source;
    private KafkaTemplate<String, CloudEvent> kafkaTemplate;

    public CloudEvent send(Object payload) {
        return send(payload, CloudEventRoute.EMPTY);
    }

    public CloudEvent send(Object payload, CloudEventRoute options) {
        CloudEvent event = CloudEventBuilder
                .v1()
                .withId(UUID.randomUUID().toString())
                .withType(Optional.ofNullable(options.getType()).orElse(type))
                .withSource(Optional.ofNullable(options.getSource()).orElse(source))
                .withDataContentType("application/json")
                .withData(Optional
                        .ofNullable(payload)
                        .map(v -> PojoCloudEventData.wrap(v, objectMapper::writeValueAsBytes))
                        .orElse(null))
                .build();

        kafkaTemplate.send(
                Optional.ofNullable(options.getTopic()).orElse(topic),
                event
        );

        return event;
    }
}
