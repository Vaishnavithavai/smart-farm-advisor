package com.example.KrishiMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.KrishiMitra.dto.LoginRequest;
import com.example.KrishiMitra.dto.RegisterRequest;
import com.example.KrishiMitra.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(
            @RequestBody
            RegisterRequest request) {

        return service.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody
            LoginRequest request) {

        return service.login(request);
    }
}