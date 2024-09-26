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
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "review_id")
    public List<Users> user;
    public String name;
    public String rating;
    public String comment;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    public Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Date updatedAt;
}
