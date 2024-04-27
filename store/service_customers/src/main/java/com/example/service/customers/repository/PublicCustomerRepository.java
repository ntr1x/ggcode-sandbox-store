package com.example.service.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.customers.entity.PublicCustomerEntity;

public interface PublicCustomerRepository extends JpaRepository<PublicCustomerEntity, java.util.UUID> {
}
