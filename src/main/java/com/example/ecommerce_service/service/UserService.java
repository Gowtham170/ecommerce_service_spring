package com.example.ecommerce_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_service.model.Users;
import com.example.ecommerce_service.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    public UserRepository userRepo;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationManager authManager;

    @Autowired
    public JwtService jwtService;

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    
    public String login(Users user) {
        if(authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null)) != null) 
            return jwtService.generateToken(user);
        return "Fail";
    }
}
