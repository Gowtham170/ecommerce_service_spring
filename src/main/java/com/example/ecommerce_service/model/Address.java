package com.example.ecommerce_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;
    @Column(nullable=false)
    public String address;
    @Column(nullable=false)
    public String City;
    @Column(nullable=false)
    public int postalcode;
    @Column(nullable=false)
    public String country;
}
