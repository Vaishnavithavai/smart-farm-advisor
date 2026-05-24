package com.example.KrishiMitra.controller;

import org.springframework.web.bind.annotation.
GetMapping;

import org.springframework.web.bind.annotation.
RequestMapping;

import org.springframework.web.bind.annotation.
RestController;

@RestController
@RequestMapping("/api/farm")

public class FarmController {

    @GetMapping("/dashboard")
    public String farmerDashboard() {

        return "Welcome Farmer";
    }
}