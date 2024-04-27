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
@Table(schema = "public", name = "customer")
public class PublicCustomerEntity {
    
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    private java.util.UUID id;
    
    @Column(name = "email", columnDefinition = "text")
    private java.lang.String email;
    
    @Column(name = "phone", columnDefinition = "text")
    private java.lang.String phone;
    
    @Column(name = "name", columnDefinition = "text")
    private java.lang.String name;
}
