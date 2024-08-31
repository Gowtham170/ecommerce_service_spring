package com.example.ecommerce_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/")
    public String sayHello() {
        return  "Hello";
    }
}
