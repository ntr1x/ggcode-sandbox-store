package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicCustomerEntity;

public interface PublicCustomerRepository extends JpaRepository<PublicCustomerEntity, java.util.UUID> {
}
