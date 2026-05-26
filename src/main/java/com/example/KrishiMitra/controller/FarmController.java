package com.example.KrishiMitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.KrishiMitra.dto.*;
import com.example.KrishiMitra.service.*;

@RestController
@RequestMapping("/api/farm")

public class FarmController {

    @Autowired
    private WeatherService
            weatherService;

    @Autowired
    private FarmRuleService
            ruleService;

    @PostMapping("/advice")
    public FarmAdviceResponse
    getAdvice(
            @RequestBody
            FarmRequest request) {

        String weather =
                weatherService
                        .getWeather(
                                request.getCity());

        return ruleService
                .getRecommendation(
                        request,
                        weather);
    }
}