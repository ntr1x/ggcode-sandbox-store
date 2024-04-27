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
@Table(schema = "public", name = "order")
public class PublicOrderEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "customer_id", columnDefinition = "uuid")
    private java.util.UUID customerId;
    
    @Column(name = "order_type_id")
    private java.lang.Integer orderTypeId;
    
    @Column(name = "order_status_id")
    private java.lang.Integer orderStatusId;
    
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicCustomerEntity customer;
    
    @ManyToOne
    @JoinColumn(name = "order_type_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicOrderTypeEntity orderType;
    
    @ManyToOne
    @JoinColumn(name = "order_status_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicOrderStatusEntity orderStatus;
}
