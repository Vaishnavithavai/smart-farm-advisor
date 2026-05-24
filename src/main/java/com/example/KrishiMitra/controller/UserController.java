package com.example.KrishiMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.KrishiMitra.dto.RegisterRequest;
import com.example.KrishiMitra.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(
        @RequestBody RegisterRequest request
    ) {
        return service.register(request);
    }
}