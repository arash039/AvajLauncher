package com.avj;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower p_tower);

	void printName();
	String getName();
	String getType();
	long getId();
}
