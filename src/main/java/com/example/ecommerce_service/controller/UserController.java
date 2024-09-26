package com.example.ecommerce_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_service.model.Users;
import com.example.ecommerce_service.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String sayHello() {
        return  "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        return ResponseEntity.ok(userService.login(user));
    }
}
