package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Shipment;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query("SELECT s FROM Shipment s WHERE s.status = :status")
    List<Shipment> findByStatus(@Param("status") String status);

    @Query("SELECT s FROM Shipment s WHERE s.destination = :destination")
    List<Shipment> findByDestination(@Param("destination") String destination);

}
