package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deliveryagent")
@Data
@NoArgsConstructor
public class Deliveryagent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String name;
    public String phoneNumber;
    public String email;
    public String area;
    public boolean isAvailable;
    public double rating;

    public Deliveryagent(Long id,String name,String phonenumber,String email,String area,boolean isAvailable,double rating){
        this.id=id;
        this.name=name;
        this.phoneNumber=phonenumber;
        this.email=email;
        this.area=area;
        this.isAvailable=isAvailable;
        this.rating=rating;

    }
}
