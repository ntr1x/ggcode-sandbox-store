package com.example.service.customers.listener;

import com.example.service.customers.entity.PublicCustomerEntity;
import com.example.service.customers.model.PublicCustomerVerifyEmailModel;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyEmailModel;
import com.example.service.customers.repository.PublicCustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.vavr.control.Try;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.ntr1x.common.events.CloudEventsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@Slf4j
@Component
public class UpdateEmailListener {

    @Autowired
    private PublicCustomerRepository publicCustomerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @KafkaListener(
        containerFactory = CloudEventsConstants.CONTAINER_FACTORY_CLOUD_EVENT,
        groupId = "service_customers",
        topicPattern = "update_email"
    )
    public void listen(ConsumerRecord<String, CloudEvent> record, Acknowledgment ack) {
        try {
            CloudEventData data = record.value().getData();
            ProfilePublicCustomerVerifyEmailModel payload = Optional.ofNullable(data)
                    .map(d -> Try.of(() -> objectMapper.readValue(new ByteArrayInputStream(d.toBytes()), ProfilePublicCustomerVerifyEmailModel.class)))
                    .orElse(Try.success(null))
                    .get();

            if (payload != null) {
                PublicCustomerEntity customer = publicCustomerRepository
                        .getReferenceById(payload.getCustomer().getId())
                        .toBuilder()
                        .email(payload.getEmail())
                        .build();

                publicCustomerRepository.save(customer);
            }

            ack.acknowledge();
        } catch (Exception e) {
            log.error("Cannot update customer email", e);
        }
    }
}
