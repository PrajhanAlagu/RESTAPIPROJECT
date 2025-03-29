package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Deliveryagent;

@Repository
public interface DeliveryagentRepository extends JpaRepository<Deliveryagent, Long> {
    // Basic CRUD operations are automatically provided by JpaRepository
}
