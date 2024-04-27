package com.example.service.events.listener;

import com.example.service.events.entity.PublicEventEntity;
import com.example.service.events.repository.PublicEventRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.kafka.impl.KafkaHeaders;
import io.vavr.control.Try;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.ntr1x.common.events.CloudEventsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PublicEventListener {

    @Autowired
    private PublicEventRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @KafkaListener(
            containerFactory = CloudEventsConstants.CONTAINER_FACTORY_CLOUD_EVENT,
            batch = "true",
            groupId = "service_events",
            topicPattern = "public_.*"
    )
    public void listen(List<ConsumerRecord<String, CloudEvent>> list, Acknowledgment ack) {
        try {
            List<PublicEventEntity> entities = list
                    .stream()
                    .map(record -> {
                        CloudEvent event = record.value();
                        CloudEventData data = event.getData();

                        if (!MediaType.APPLICATION_JSON_VALUE.equals(event.getDataContentType())) {
                            return null;
                        }

                        JsonNode payload = Optional.ofNullable(data)
                                .map(d -> Try.of(() -> objectMapper.readTree(new ByteArrayInputStream(d.toBytes()))))
                                .orElse(Try.success(null))
                                .get();

                        Headers headers = record.headers();
                        return PublicEventEntity
                                .builder()
                                .id(UUID.randomUUID())
                                .topic(record.topic())
                                .ceId(event.getId())
                                .ceSource(KafkaHeaders.getParsedKafkaHeader(headers, "ce_source"))
                                .ceType(KafkaHeaders.getParsedKafkaHeader(headers, "ce_type"))
                                .ceSpecification(KafkaHeaders.getParsedKafkaHeader(headers, "ce_specversion"))
                                .ceId(KafkaHeaders.getParsedKafkaHeader(headers, "ce_id"))
                                .contentType(KafkaHeaders.getParsedKafkaHeader(headers, "content-type"))
                                .payload(payload)
                                .build();
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            repository.saveAll(entities);

            ack.acknowledge();
        } catch (Exception e) {
            log.error("Cannot persist cloud events", e);
        }
    }
}
