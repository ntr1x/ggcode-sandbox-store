package com.example.service.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.events.entity.PublicEventEntity;

public interface PublicEventRepository extends JpaRepository<PublicEventEntity, java.util.UUID> {
}
