package com.example.ecommerce_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce_service.model.UserPrinicipal;
import com.example.ecommerce_service.model.Users;
import com.example.ecommerce_service.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User Not Found");
        return new UserPrinicipal(user);
    }
    
}
