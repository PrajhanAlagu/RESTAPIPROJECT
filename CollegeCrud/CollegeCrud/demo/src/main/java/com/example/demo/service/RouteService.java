package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.demo.entity.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;

@Service        
public class RouteService {
    
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }   

    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    public Route createRoute(Route route) {
        if (route.getId() != null && routeRepository.existsById(route.getId())) {
            throw new ResourceAlreadyExistsException("Route already exists with id: " + route.getId());
        }
        return routeRepository.save(route);
    }

    public void deleteRoute(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Route not found with id: " + id);
        }
        routeRepository.deleteById(id); 
    }

    public Route updateRoute(Long id, Route route) {
        if (!routeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Route not found with id: " + id);
        }
        route.setId(id);
        return routeRepository.save(route);
    }
}
