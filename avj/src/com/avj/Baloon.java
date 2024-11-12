package com.avj;

public class Baloon extends Aircraft {
	protected WeatherTower weatherTower = new WeatherTower();

    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
    }
    @Override
    public void updateConditions(){
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				System.out.println("Baloon#" + name + "(" + id + "): Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				System.out.println("Baloon#" + name + "(" + id + "): Damn you rain! You messed up my baloon.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				System.out.println("Baloon#" + name + "(" + id + "): Oh! It's getting foggy.");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				System.out.println("Baloon#" + name + "(" + id + "): It's snowing. We're gonna crash.");
				break;
		}
		if (coordinates.height > 100)
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
		if (coordinates.height <= 0) {
			System.out.println("Baloon#" + name + "(" + id + "): landing.");
			this.weatherTower.unregister(this);
		}
	}

    @Override
    public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
		weatherTower.register(this);
	}

	@Override
	public void printName(){
		System.out.println(id + " " + name);
	}
}
