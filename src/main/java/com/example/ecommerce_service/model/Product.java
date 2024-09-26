package com.example.ecommerce_service.model;

import java.util.Date;
import java.util.Set;

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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String image;
    @Column(nullable = false)
    public String description;
    @Column(nullable = false)
    public String brand;
    @Column(nullable = false)
    public String category;
    @Column(nullable = false)
    public double price;
    @Column(nullable = false)
    public int countInStock;
    @Column(nullable = false)
    public int rating;
    @Column(nullable = false)
    public int numReviews;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Set<Review> reviews;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    public Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Date updatedAt;
}