package com.avj;

public class WeatherTower extends Tower{
	String getWeather(Coordinates p_coordinates){
		return (WeatherProvider.getWeatherProvider().getCurrentWeather(p_coordinates));
	};
	void changeWeather(){
		this.conditionChanged();
	};
}