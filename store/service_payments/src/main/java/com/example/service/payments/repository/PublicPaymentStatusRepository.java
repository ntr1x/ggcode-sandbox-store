package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicPaymentStatusEntity;

public interface PublicPaymentStatusRepository extends JpaRepository<PublicPaymentStatusEntity, java.util.UUID> {
}
