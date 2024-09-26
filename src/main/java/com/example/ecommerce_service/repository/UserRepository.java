package com.example.ecommerce_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_service.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    
    public Users findByUsername(String user);
}
