package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.entity.Shipment;
import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    public List<Shipment> getShipmentsByStatus(String status) {
        return shipmentRepository.findByStatus(status);
    }

    public List<Shipment> getShipmentsByDestination(String destination) {
        return shipmentRepository.findByDestination(destination);
    }

    public Shipment updateShipment(Long id, Shipment shipment) {
        shipment.setId(id);
        return shipmentRepository.save(shipment);
    }
}
