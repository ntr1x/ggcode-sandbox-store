package com.example.service.customers.listener;

import com.example.service.customers.entity.PublicCustomerEntity;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyPhoneModel;
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
public class UpdatePhoneListener {

    @Autowired
    private PublicCustomerRepository publicCustomerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @KafkaListener(
        containerFactory = CloudEventsConstants.CONTAINER_FACTORY_CLOUD_EVENT,
        groupId = "service_customers",
        topicPattern = "update_phone"
    )
    public void listen(ConsumerRecord<String, CloudEvent> record, Acknowledgment ack) {
        try {
            CloudEventData data = record.value().getData();
            ProfilePublicCustomerVerifyPhoneModel payload = Optional.ofNullable(data)
                    .map(d -> Try.of(() -> objectMapper.readValue(new ByteArrayInputStream(d.toBytes()), ProfilePublicCustomerVerifyPhoneModel.class)))
                    .orElse(Try.success(null))
                    .get();

            if (payload != null) {
                PublicCustomerEntity customer = publicCustomerRepository
                        .getReferenceById(payload.getCustomer().getId())
                        .toBuilder()
                        .phone(payload.getPhone())
                        .build();

                publicCustomerRepository.save(customer);
            }

            ack.acknowledge();
        } catch (Exception e) {
            log.error("Cannot update customer phone", e);
        }
    }
}
