package com.example.KrishiMitra.service;

import org.springframework.stereotype.Service;

import com.example.KrishiMitra.dto.*;
import com.example.KrishiMitra.enums.*;

@Service
public class FarmRuleService {

    public FarmAdviceResponse
    getRecommendation(
            FarmRequest request,
            String weather) {

        String advice =
                generateAdvice(
                        request.getCrop(),
                        request.getStage(),
                        weather
                );

        FarmAdviceResponse response =
                new FarmAdviceResponse();

        response.setCrop(
                request.getCrop().name());

        response.setWeather(
                weather);

        response.setRecommendation(
                advice);

        return response;
    }

    private String generateAdvice(
            CropType crop,
            FarmStage stage,
            String weather) {

        if (crop == CropType.WHEAT
                && stage ==
                FarmStage.SOWING
                && weather.equalsIgnoreCase(
                "Rain")) {

            return "Avoid irrigation today";
        }

        if (crop == CropType.RICE
                && weather.equalsIgnoreCase(
                "Sunny")) {

            return "Good time for irrigation";
        }

        return
                "Monitor weather regularly";
    }
}