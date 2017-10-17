package com.example.guest.weather.models;

/**
 * Created by Guest on 10/17/17.
 */

public class Forecast {
    private double temp;
    private double temp_max;
    private double temp_min;
    private String currentWeather;
    private int timeForecast;

    public Forecast(double temp, double temp_max, double temp_min, String currentWeather, int timeForecast) {
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.currentWeather = currentWeather;
        this.timeForecast = timeForecast;
    }

    public double getTemp() {
        return temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public int getTimeForecast() {
        return timeForecast;
    }
}
