package com.example.service.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.customers.entity.PublicCustomerVerifyEmailEntity;

public interface PublicCustomerVerifyEmailRepository extends JpaRepository<PublicCustomerVerifyEmailEntity, java.util.UUID> {
}
