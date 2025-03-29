package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Payment entity representing a payment record")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the payment")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private  Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    @NotNull
    @Schema(description = "User who made the payment")
    private User user;

    @Positive
    @Schema(description = "Payment amount")
    private double amount;

    @NotNull
    @Schema(description = "Payment method (e.g., Credit Card, PayPal)")
    private String paymentMethod;
    public Payment(Long id, User user, double amount, String paymentMethod,Delivery delivery) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.delivery=delivery;
    }   
}