package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Shipment entity representing a shipment record")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the shipment")
    private Long id;

    @NotBlank
    @Schema(description = "Origin location of the shipment")
    private String origin;

    @NotBlank
    @Schema(description = "Destination location of the shipment")
    private String destination;

    @NotBlank
    @Schema(description = "Date when shipment was created")
    private String shipmentDate;

    @Schema(description = "Estimated delivery date")
    private String estimatedDeliveryDate;

    @NotBlank
    @Schema(description = "Current status of the shipment")
    private String status;

    @Positive
    @Schema(description = "Weight of the shipment")
    private double weight;

    @Positive
    @Schema(description = "Volume of the shipment")
    private double volume;

    @Positive
    @Schema(description = "Cost of the shipment")
    private double cost;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    @Schema(description = "List of deliveries associated with this shipment")
    private List<Delivery> deliveries;

    // Constructor for setting values
    public Shipment(Long id, String origin, String destination, String shipmentDate,
                   String estimatedDeliveryDate, String status, double weight,
                   double volume, double cost, List<Delivery> deliveries) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.shipmentDate = shipmentDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.deliveries = deliveries;
    }
}
