package com.avj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScenarioParser {
	protected static AircraftFactory factory = AircraftFactory.getFactoryInstance();
	static WeatherTower weatherTower = new WeatherTower();
	static List<Flyable> flyList = new ArrayList<>();
	static int simulationRounds;
	static int longitude;
	static int latitude;
	static int height;

	public static void scenarioParser(String path) {
		try	(BufferedReader bufferReader = new BufferedReader(new FileReader(path))){
			String line;
			int lineCounter = 0;
			while ((line = bufferReader.readLine()) != null) {
				if (lineCounter == 0) {
					if (!line.isEmpty()) {
						try {
							simulationRounds = Integer.parseInt(line);
							if (simulationRounds < 0) {
								//System.out.println("Error! Number of simulation rounds can't be negative");
								//System.exit(1);
								throw new CustomException("Number of simulation rounds can't be negative");
							}
							lineCounter++;
						} catch (NumberFormatException e){
							System.out.println("File should start with a positive number of simulation rounds");
							System.exit(1);
						} catch (CustomException e){
							//e.printStackTrace();
							System.out.println("\u001B[31mError! Number of simulation rounds can't be negative\u001B[0m");
							System.exit(1);
						}
					}
				} else {
					if (line.isEmpty())
						continue;
					String[] dividedLine = line.trim().split("\\s+");
					if (checkValidity(dividedLine) == false) {
						System.out.println("error in scenario file format");
						System.exit(1);
					}
					Coordinates lineCoordinates = new Coordinates(longitude, latitude, height);
					Flyable lineAircraft = factory.newAircraft(dividedLine[0], dividedLine[1], lineCoordinates);
					flyList.add(lineAircraft);
					//lineAircraft.registerTower(weatherTower);
				}
			} 
		} catch (IOException e){
				e.printStackTrace();
				System.exit(1);
		}
	}

	private static boolean checkValidity(String[] line) {
		String[] types = {"Baloon", "Helicopter", "JetPlane"};

		if (line.length != 5)
			return false;
		if (!Arrays.asList(types).contains(line[0]))
			return false;
		if (line[1] != null && !line[1].matches("[a-zA-Z0-9]+"))	
			return false;
		try {
			longitude = Integer.parseInt(line[2]); 
			latitude = Integer.parseInt(line[3]); 
			height= Integer.parseInt(line[4]);
			if (longitude < 0 || latitude < 0 || height < 0) {
				System.out.println("Coordinates should be positive");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.out.println("Coordinates should be integers");
			System.exit(1);
		}
		return true;
	}
}
