package com.example.ecommerce_service.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Users {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public long id;
    @Column(name = "name", nullable = false)
    public String username;
    @Column(nullable = false, unique = true)
    public String email;
    @Column(nullable = false)
    public String password;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    public List<Product> products;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    public Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Date updatedAt;
}
