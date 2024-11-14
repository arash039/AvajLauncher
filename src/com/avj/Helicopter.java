package com.avj;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
    }
    @Override
    public void updateConditions(){
		String weather = WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				System.out.println("Helicopter#" + name + "(" + id + "): This is hot.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				System.out.println("Helicopter#" + name + "(" + id + "): Oh! Started to rain.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				System.out.println("Helicopter#" + name + "(" + id + "): Oh! It's getting foggy.");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				System.out.println("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
				break;
		}
		if (coordinates.height > 100)
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
		if (coordinates.height <= 0) {
			System.out.println("Helicopter#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
	}
}
