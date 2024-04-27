package com.example.service.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.catalog.entity.PublicProductEntity;

public interface PublicProductRepository extends JpaRepository<PublicProductEntity, java.util.UUID> {
}
