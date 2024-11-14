package com.avj;

public class AircraftFactory {
	private static AircraftFactory factoryInstance;
	long id = 0;

	private AircraftFactory(){}
	public static AircraftFactory getFactoryInstance(){
		if (factoryInstance == null)
			factoryInstance = new AircraftFactory();
		return factoryInstance;
	}
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		if ("Baloon".equalsIgnoreCase(p_type))
			return (new Baloon(id++, p_name, p_coordinates));
		else if ("Helicopter".equalsIgnoreCase(p_type))
			return (new Helicopter(id++, p_name, p_coordinates));
		else if ("JetPlane".equalsIgnoreCase(p_type))
			return (new JetPlane(id++, p_name, p_coordinates));
		else
			return null;
	}
}
