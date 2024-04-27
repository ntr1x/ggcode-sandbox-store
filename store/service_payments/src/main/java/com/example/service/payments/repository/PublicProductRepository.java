package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicProductEntity;

public interface PublicProductRepository extends JpaRepository<PublicProductEntity, java.util.UUID> {
}
