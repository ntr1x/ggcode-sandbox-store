package com.example.service.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.basket.entity.PublicCustomerEntity;

public interface PublicCustomerRepository extends JpaRepository<PublicCustomerEntity, java.util.UUID> {
}
