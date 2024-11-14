package com.avj;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	public Aircraft(long p_id, String p_name, Coordinates p_coordinates){
		name = p_name;
		id = p_id;
		coordinates = p_coordinates;
	}

	public void updateConditions(){}
	
	@Override
	public void registerTower(WeatherTower p_tower){
		weatherTower = p_tower;
		weatherTower.register(this);
	}
	
	@Override
	public String getName(){
		return (this.name);
	}

	@Override
	public long getId(){
		return (this.id);
	}

	@Override
	public String getType(){
		return (this.getClass().getSimpleName());
	}
}
