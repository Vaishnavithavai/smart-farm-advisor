package com.example.KrishiMitra.dto;

import java.util.List;




public class WeatherResponse {

    public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	private List<Weather> weather;

  
    public static class Weather {

        public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		private String main;
    }
}