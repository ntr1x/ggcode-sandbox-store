package com.example.service.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.basket.entity.PublicBasketEntryEntity;

public interface PublicBasketEntryRepository extends JpaRepository<PublicBasketEntryEntity, java.util.UUID> {
}
