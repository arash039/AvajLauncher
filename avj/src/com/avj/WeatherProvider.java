package com.avj;

public class WeatherProvider {
    String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
	private static WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider(){}
	public static WeatherProvider getProvider() {
		return weatherProvider;
	}
    public String getCurrentWeather(Coordinates p_coordinates){
        return weather[(int) (Math.random() * weather.length)];
    }
}
