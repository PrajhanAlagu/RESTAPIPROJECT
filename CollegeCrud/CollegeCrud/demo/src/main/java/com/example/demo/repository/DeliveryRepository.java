package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Delivery;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Query("SELECT d FROM Delivery d WHERE d.status = :status")
    List<Delivery> findByStatus(@Param("status") String status);

    @Query("SELECT d FROM Delivery d WHERE d.recipient = :recipient")
    List<Delivery> findByRecipient(@Param("recipient") String recipient);

}
