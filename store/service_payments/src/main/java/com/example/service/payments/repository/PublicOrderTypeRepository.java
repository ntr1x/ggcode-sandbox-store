package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicOrderTypeEntity;

public interface PublicOrderTypeRepository extends JpaRepository<PublicOrderTypeEntity, java.util.UUID> {
}
