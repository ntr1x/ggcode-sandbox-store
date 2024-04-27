package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicPaymentEntity;

public interface PublicPaymentRepository extends JpaRepository<PublicPaymentEntity, java.util.UUID> {
}
