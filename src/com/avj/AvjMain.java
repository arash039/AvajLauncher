package com.avj;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AvjMain {
	public static void main(String[] args) {
		String filePath = args[0];
		ScenarioParser.scenarioParser(filePath);
		try {
			PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(fileOut);
			for (Flyable index : ScenarioParser.flyList)
				index.registerTower(ScenarioParser.weatherTower);
			for (int i = 1; i <= ScenarioParser.simulationRounds; i++){
				if (ScenarioParser.weatherTower.earlyEnd == true) {
					System.out.println("\n\n all flyables landed. simulation ends here");
					return;
				}
				//System.out.println("\033[1mSimulation Round " + i + "\033[0m");
				System.out.println("\nSimulation Round " + i + "\n");
				ScenarioParser.weatherTower.changeWeather();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
