package com.example.service.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.service.customers.entity.PublicCustomerVerifyPhoneEntity;

public interface PublicCustomerVerifyPhoneRepository extends JpaRepository<PublicCustomerVerifyPhoneEntity, java.util.UUID> {
}
