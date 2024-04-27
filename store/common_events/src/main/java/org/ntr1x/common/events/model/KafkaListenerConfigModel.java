package org.ntr1x.common.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.regex.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaListenerConfigModel {
    private String groupId;
    private String clientId;
    private Integer concurrency;
    private Pattern topicPattern;
    private String[] topics;
    private String topic;
    private ContainerProperties.AckMode ackMode;
}
