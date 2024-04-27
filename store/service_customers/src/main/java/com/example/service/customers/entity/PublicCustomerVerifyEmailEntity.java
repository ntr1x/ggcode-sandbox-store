package com.example.service.customers.entity;

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
@Table(schema = "public", name = "customer_verify_email")
public class PublicCustomerVerifyEmailEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "customer_id", columnDefinition = "uuid")
    private java.util.UUID customerId;
    
    @Column(name = "email", columnDefinition = "text")
    private java.lang.String email;
    
    @Column(name = "secret", columnDefinition = "text")
    private java.lang.String secret;
    
    @Column(name = "is_confirmed")
    private java.lang.Boolean isConfirmed;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private com.example.service.customers.entity.PublicCustomerEntity customer;
}
