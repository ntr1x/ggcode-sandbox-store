package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicPaymentTypeEntity;

public interface PublicPaymentTypeRepository extends JpaRepository<PublicPaymentTypeEntity, java.util.UUID> {
}
