package com.example.service.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.basket.entity.PublicProductEntity;

public interface PublicProductRepository extends JpaRepository<PublicProductEntity, java.util.UUID> {
}
