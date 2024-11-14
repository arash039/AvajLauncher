package com.avj;

public abstract class Flyable {
	protected WeatherTower weatherTower;

	abstract void updateConditions();
	abstract void registerTower(WeatherTower p_tower);
	abstract String getName();
	abstract String getType();
	abstract long getId();
}
