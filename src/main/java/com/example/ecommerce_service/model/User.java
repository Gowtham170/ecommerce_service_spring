package com.example.ecommerce_service.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name =  "_User")
@Data
public class User {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public long id;
    @Column(name = "name", nullable = false)
    public String username;
    @Column(nullable = false, unique = true)
    public String eamil;
    @Column(nullable = false, length = 8)
    public String password;
    @Column(nullable = false)
    public boolean isAdmin = false;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    public Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Date updatedAt;
}
