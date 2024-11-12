package com.avj;

public class JetPlane extends Aircraft {
	protected WeatherTower weatherTower = new WeatherTower();
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
    }
    @Override
    public void updateConditions(){
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				System.out.println("JetPlane#" + name + "(" + id + "): Warm day.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				System.out.println("JetPlane#" + name + "(" + id + "): It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				System.out.println("JetPlane#" + name + "(" + id + "): Oops! It's getting foggy.");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				System.out.println("JetPlane#" + name + "(" + id + "): OMG! Winter is coming!");
				break;
		}
		if (coordinates.height > 100)
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
		if (coordinates.height <= 0) {
			System.out.println("JetPlane#" + name + "(" + id + "): landing.");
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
