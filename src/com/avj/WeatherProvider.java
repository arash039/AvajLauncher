package com.avj;

public class WeatherProvider {
	String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};
	private static WeatherProvider weatherProvider = new WeatherProvider();

	private WeatherProvider(){}
	public static WeatherProvider getWeatherProvider(){
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates p_coordinates){
		String weatheString = weather[(int) (Math.random() * weather.length)];
		return (weatheString);
	}
}
