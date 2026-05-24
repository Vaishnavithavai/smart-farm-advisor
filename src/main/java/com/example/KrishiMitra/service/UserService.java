package com.example.KrishiMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.KrishiMitra.dto.RegisterRequest;
import com.example.KrishiMitra.entity.User;
import com.example.KrishiMitra.enums.Role;
import com.example.KrishiMitra.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String register(
            RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user.setRole(
            Role.valueOf(
                request.getRole().toUpperCase()
            )
        );

        repo.save(user);

        return "User Registered";
    }
}