package com.avj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory factory = AircraftFactory.getInstance();
		List<Flyable> allFlyables = new ArrayList<>();
		String filePath = args[0];
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		int simulationCount = 0;
		byte lineCounter = 0;
		while ((line = br.readLine()) != null) {
			if (lineCounter == 0) {
				if (!line.isEmpty()) {
					try {
						simulationCount = Integer.parseInt(line.trim());
						if (simulationCount < 0) {
							System.out.println("Error! Number of simulation rounds can't be negative");
							System.exit(1);
						}
						lineCounter++;
					} catch (NumberFormatException e){
						System.out.println("File should start with a positive number of simulation rounds");
						System.exit(1);
					}
				}
			} else {
				String[] dividedLine = line.trim().split("\\s+");
				if (checkValidity(dividedLine) == false) {
					System.out.println("error");
					System.exit(1);
				}
				Coordinates lineCoordinates = new Coordinates(Integer.parseInt(dividedLine[2]), Integer.parseInt(dividedLine[3]), Integer.parseInt(dividedLine[4]));
				Flyable lineCraft = factory.newAircraft(dividedLine[0], dividedLine[1], lineCoordinates);
				//allFlyables.add(lineCraft);
				weatherTower.register(lineCraft);
			}
			//System.out.println(line);
		}
		// for (Flyable x : allFlyables)
		// 	x.printName();
		for (int i = 1; i < simulationCount; i++){
			System.out.println("\033[1mSimulation Round " + i + "\033[0m");
			weatherTower.changeWeather();
		}

	}        
	public static boolean checkValidity(String[] line) {
		String[] types = {"Baloon", "Helicopter", "JetPlane"};
		if (line.length != 5)
			return false;
		if (!Arrays.asList(types).contains(line[0]))
			return false;
		if (line[1] != null && !line[1].matches("[a-zA-Z0-9]+"))
			return false;
		if (!line[2].matches("\\d+") || !line[3].matches("\\d+") || !line[4].matches("\\d+"))
			return false;
		return true;
	}
	public static void flySimulation(List<Flyable> allFlyables) {

	}

}
