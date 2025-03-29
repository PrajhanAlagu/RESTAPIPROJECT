package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import com.example.demo.entity.Deliveryagent;
import com.example.demo.service.DeliveryagentService;

@RestController
@RequestMapping("/api/deliveryagents")  
public class DeliveryagentController {

    @Autowired          
    private DeliveryagentService deliveryagentService;

    @GetMapping
    public List<Deliveryagent> getAllDeliveryagents() {
        return deliveryagentService.getAllDeliveryagents();
    }

    @GetMapping("/{id}")
    public Deliveryagent getDeliveryagentById(@PathVariable Long id) {
        return deliveryagentService.getDeliveryagentById(id);
    }

    @PostMapping
    public Deliveryagent createDeliveryagent(@RequestBody Deliveryagent agent) {
        return deliveryagentService.createDeliveryagent(agent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deliveryagent> updateDeliveryagent(@PathVariable Long id, @RequestBody Deliveryagent agent) {
        Deliveryagent updatedAgent = deliveryagentService.updateDeliveryagent(id, agent);
        return ResponseEntity.ok(updatedAgent);
    }

    @DeleteMapping("/deleteby")
    public ResponseEntity<String> deleteDeliveryAgent(@RequestParam Long id) {
        boolean isDeleted = deliveryagentService.deleteDeliveryagentById(id);    
        
        if (isDeleted) {
            return ResponseEntity.ok("Delivery agent deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delivery agent not found");
        }
    }

}
