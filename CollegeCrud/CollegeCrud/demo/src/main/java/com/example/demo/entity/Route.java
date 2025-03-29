package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "routes")
public class Route {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Source location is required")
    private String source;
    
    @NotBlank(message = "Destination location is required")
    private String destination;
    
    private Double distance;
    
    private Integer duration; // in minutes
    
    private String transportMode;
    public Route(Long id,String source,String destination,Double distance,Integer duration,String transportMode){
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.distance=distance;
        this.duration=duration;
        this.transportMode=transportMode;
    }
}