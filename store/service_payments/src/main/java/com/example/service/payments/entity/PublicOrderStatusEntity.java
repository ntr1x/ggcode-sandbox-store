package com.example.service.payments.entity;

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
@Table(schema = "public", name = "order_status")
public class PublicOrderStatusEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "name", columnDefinition = "text")
    private java.lang.String name;
    
    @Column(name = "description", columnDefinition = "text")
    private java.lang.String description;
}
