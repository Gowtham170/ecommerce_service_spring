package com.example.ecommerce_service.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PaymentResult {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    public String status;
    @Column(nullable = false)
    public Date update_time;
    @Column(nullable = false, name="email_address")
    public String emailAddress;
}
