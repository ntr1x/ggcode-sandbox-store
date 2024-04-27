package org.ntr1x.common.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CloudEventRoute {
    private String topic;
    private String type;
    private URI source;

    public static final CloudEventRoute EMPTY = new CloudEventRoute();
}
