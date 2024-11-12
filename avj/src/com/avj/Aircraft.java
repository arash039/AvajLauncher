package com.avj;

public class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }
    
    @Override
    public void updateConditions(){}

    @Override
    public void registerTower(WeatherTower p_tower){}

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

	@Override
	public void printName(){}
}
