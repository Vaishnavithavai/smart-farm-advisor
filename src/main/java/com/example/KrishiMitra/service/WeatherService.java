package com.example.KrishiMitra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.example.KrishiMitra.dto.WeatherResponse;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String weatherUrl;

    public String getWeather(
            String city) {

        String url =
                weatherUrl
                + "?q=" + city
                + "&appid=" + apiKey;

        WeatherResponse response =
                restTemplate.getForObject(
                        url,
                        WeatherResponse.class
                );

        if(response != null
                && response.getWeather()
                != null
                && !response.getWeather()
                        .isEmpty()) {

            return response
                    .getWeather()
                    .get(0)
                    .getMain();
        }

        return "Unknown";
    }
}