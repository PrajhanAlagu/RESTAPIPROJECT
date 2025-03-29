package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DeliveryagentRepository;
import com.example.demo.entity.Deliveryagent;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class DeliveryagentService {

    @Autowired
    private DeliveryagentRepository deliveryagentRepository;

    public List<Deliveryagent> getAllDeliveryagents() {
        return deliveryagentRepository.findAll();
    }

    public Deliveryagent getDeliveryagentById(Long id) {
        return deliveryagentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Delivery agent not found with id: " + id));
    }

    public Deliveryagent createDeliveryagent(Deliveryagent agent) {
        return deliveryagentRepository.save(agent);
    }

    public Deliveryagent updateDeliveryagent(Long id, Deliveryagent agent) {
        if (!deliveryagentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Delivery agent not found with id: " + id);
        }
        agent.setId(id);
        return deliveryagentRepository.save(agent);
    }

    public boolean deleteDeliveryagentById(Long id) {
        if (deliveryagentRepository.existsById(id)) {
            deliveryagentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
