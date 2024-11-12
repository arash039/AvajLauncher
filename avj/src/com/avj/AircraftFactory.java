package com.avj;

public class AircraftFactory {
	private static AircraftFactory instance;
	IdMaker idMaker = new IdMaker();

	private AircraftFactory(){}
	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		if ("Baloon".equalsIgnoreCase(p_type))
			return (new Baloon(idMaker.getId(), p_name, p_coordinates));
		else if ("Helicopter".equalsIgnoreCase(p_type))
			return (new Helicopter(idMaker.getId(), p_name, p_coordinates));
		else if ("JetPlane".equalsIgnoreCase(p_type))
			return (new JetPlane(idMaker.getId(), p_name, p_coordinates));
		else
			return null;
	}

}
