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
@Table(schema = "public", name = "order_entry")
public class PublicOrderEntryEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "product_id", columnDefinition = "uuid")
    private java.util.UUID productId;
    
    @Column(name = "order_id", columnDefinition = "uuid")
    private java.util.UUID orderId;
    
    @Column(name = "quantity")
    private java.lang.Integer quantity;
    
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicOrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private com.example.service.payments.entity.PublicProductEntity product;
}
