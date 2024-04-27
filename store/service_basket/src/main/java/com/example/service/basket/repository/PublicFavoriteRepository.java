package com.example.service.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.basket.entity.PublicFavoriteEntity;

public interface PublicFavoriteRepository extends JpaRepository<PublicFavoriteEntity, java.util.UUID> {
}
