package com.example.service.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.catalog.entity.PublicCategoryEntity;

public interface PublicCategoryRepository extends JpaRepository<PublicCategoryEntity, java.util.UUID> {
}
