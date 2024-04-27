package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicOrderStatusEntity;

public interface PublicOrderStatusRepository extends JpaRepository<PublicOrderStatusEntity, java.util.UUID> {
}
