package com.example.service.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.payments.entity.PublicOrderEntryEntity;

public interface PublicOrderEntryRepository extends JpaRepository<PublicOrderEntryEntity, java.util.UUID> {
}
