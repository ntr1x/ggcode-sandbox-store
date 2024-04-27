package org.ntr1x.common.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaTopicConfigModel {
    private String name;
    private Integer partitions;
    private Short replicas;
    private Boolean compact;
    private Map<String, String> configs;
}
