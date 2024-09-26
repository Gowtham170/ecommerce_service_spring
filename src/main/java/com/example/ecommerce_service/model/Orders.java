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
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    public List<Users> user;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //@JoinColumn(name="order_id")
    @Column(name="order_items")
    public List<OrderItems> orderItems;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="shipping_address_id")
    public Address shippingAddress;
    @Column(name="payment_method")
    public String paymentMethod;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    @Column(name="payment_result")
    public List<PaymentResult> paymentResult;
    public double itemsPrice;
    public double taxPrice;
    public double totalPrice;
    public boolean  isPaid;
    public Date paidAt;
    public boolean isDelivered;
    public Date deliveredAt;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    public Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Date updatedAt;
}
