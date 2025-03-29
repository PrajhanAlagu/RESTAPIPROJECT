package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Delivery entity representing a delivery record")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the delivery")
    private Long id;

    @NotBlank
    @Schema(description = "Name of the recipient")
    private String recipient;

    @NotBlank
    @Schema(description = "Origin location of the delivery")
    private String origin;

    @NotBlank
    @Schema(description = "Destination location of the delivery")
    private String destination;

    @NotBlank
    @Schema(description = "Delivery date")
    private String deliveryDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Schema(description = "Current status of the delivery")
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    @Schema(description = "Associated shipment")
    private Shipment shipment;

    public enum DeliveryStatus {
        PENDING,
        DELIVERED
    }

    public Delivery(Long id, String recipient, String origin, String destination, 
                   String deliveryDate, DeliveryStatus status, Shipment shipment,Payment payment) {
        this.id = id;
        this.recipient = recipient;
        this.origin = origin;
        this.destination = destination;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.shipment = shipment;
        this.payment=payment;
    }
}
