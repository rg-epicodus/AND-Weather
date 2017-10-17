package com.example.guest.weather.models;

/**
 * Created by Guest on 10/17/17.
 */

public class Forecast {
    private double temp_max;
    private double temp_min;
    private String main;
    private String currentWeather;
    private int timeForecast;
    private String imageUrl;

    public Forecast(double temp_max, double temp_min, String main, String currentWeather, int timeForecast, String imageUrl) {
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.main = main;
        this.currentWeather = currentWeather;
        this.timeForecast = timeForecast;
        this.imageUrl = imageUrl;
    }


    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public String getMain() {
        return main;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public int getTimeForecast() {
        return timeForecast;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
