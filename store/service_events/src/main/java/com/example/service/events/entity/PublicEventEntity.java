package com.example.service.events.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "event")
public class PublicEventEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "topic", columnDefinition = "text")
    private java.lang.String topic;
    
    @Column(name = "content_type", columnDefinition = "text")
    private java.lang.String contentType;
    
    @Column(name = "ce_type", columnDefinition = "text")
    private java.lang.String ceType;
    
    @Column(name = "ce_source", columnDefinition = "text")
    private java.lang.String ceSource;
    
    @Column(name = "ce_specification", columnDefinition = "text")
    private java.lang.String ceSpecification;
    
    @Column(name = "ce_id", columnDefinition = "text")
    private java.lang.String ceId;
    
    @Column(name = "payload", columnDefinition = "jsonb")
    @Type(io.hypersistence.utils.hibernate.type.json.JsonBinaryType.class)
    @Lob
    private com.fasterxml.jackson.databind.JsonNode payload;
}
