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
@Table(schema = "public", name = "payment")
public class PublicPaymentEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "customer_id", columnDefinition = "uuid")
    private java.util.UUID customerId;
    
    @Column(name = "order_id", columnDefinition = "uuid")
    private java.util.UUID orderId;
    
    @Column(name = "payment_status_id", columnDefinition = "uuid")
    private java.util.UUID paymentStatusId;
    
    @Column(name = "payment_type_id", columnDefinition = "uuid")
    private java.util.UUID paymentTypeId;
    
    @Column(name = "value")
    private java.math.BigDecimal value;
    
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "payment_status_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicPaymentStatusEntity paymentStatus;
    
    @ManyToOne
    @JoinColumn(name = "payment_type_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicPaymentTypeEntity paymentType;
}
