package com.example.service.events.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ntr1x.common.api.views.Views;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PublicEventModel {
    
    @JsonView(Views.Default.class)
    private java.util.UUID id;
    
    @JsonView(Views.Default.class)
    private java.lang.String topic;
    
    @JsonView(Views.Default.class)
    private java.lang.String contentType;
    
    @JsonView(Views.Default.class)
    private java.lang.String ceType;
    
    @JsonView(Views.Default.class)
    private java.lang.String ceSource;
    
    @JsonView(Views.Default.class)
    private java.lang.String ceSpecification;
    
    @JsonView(Views.Default.class)
    private java.lang.String ceId;
    
    @JsonView(Views.Default.class)
    private com.fasterxml.jackson.databind.JsonNode payload;
}
