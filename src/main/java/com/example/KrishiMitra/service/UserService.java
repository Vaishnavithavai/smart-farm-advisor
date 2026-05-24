package com.example.KrishiMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.KrishiMitra.dto.LoginRequest;
import com.example.KrishiMitra.dto.RegisterRequest;
import com.example.KrishiMitra.entity.User;
import com.example.KrishiMitra.enums.Role;
import com.example.KrishiMitra.repository.UserRepository;
import com.example.KrishiMitra.security.JwtService;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // REGISTER USER
    public String register(
            RegisterRequest request) {

        User user = new User();

        user.setName(
                request.getName());

        user.setEmail(
                request.getEmail());

        // Encrypt password
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        user.setRole(
                Role.valueOf(
                        request.getRole()
                                .toUpperCase()));

        repo.save(user);

        return "User Registered";
    }

    // LOGIN USER
    public String login(
            LoginRequest request) {

        User user = repo.findByEmail(
                request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));

        // Check encrypted password
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        // Generate JWT Token
        return jwtService.generateToken(
                user.getEmail());
    }
}