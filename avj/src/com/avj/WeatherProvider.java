package com.avj;

public class WeatherProvider {
    String[] weather = {"SUNNY", "RAINY", "FOGGY", "SNOWY"};

    private WeatherProvider(){}
    public String getCurrentWeather(Coordinates p_coordinates){
        return weather[(int) (Math.random() * weather.length)];
    }
}
