package com.example.service.basket.entity;

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
@Table(schema = "public", name = "favorite")
public class PublicFavoriteEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "customer_id", columnDefinition = "uuid")
    private java.util.UUID customerId;
    
    @Column(name = "product_id", columnDefinition = "uuid")
    private java.util.UUID productId;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private com.example.service.basket.entity.PublicCustomerEntity customer;
    
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private com.example.service.basket.entity.PublicProductEntity product;
}
