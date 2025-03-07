# AvajLauncher
AvajLauncher is a lightweight simulation program written in Java that models the movement of aircraft in a virtual environment. The project demonstrates object-oriented programming principles, including Singleton, Observer, and Factory design patterns, while adhering to strict UML specifications.
![classes](https://github.com/arash039/AvajLauncher/blob/main/avaj_uml.png)

## Features
- Simulates the movement of various types of aircraft: Baloon, Helicopter, and JetPlane.
- Implements dynamic weather changes via a centralized weather-tower system.
- Demonstrates design patterns, including:
  - Singleton: Ensures a single instance of critical classes.
  - Observer: Manages the relationship between the weather tower and aircraft.
  - Factory: Simplifies object creation for aircraft.
## Design Patterns
### Singleton Pattern
The WeatherTower class is implemented as a Singleton. The Singleton design pattern ensures that only one instance of the weather tower exists throughout the simulation. This is critical for centralizing control and avoiding inconsistencies in weather updates.

#### Benefits:

- Guarantees a single, globally accessible instance.
- Simplifies management of shared resources.
#### Implementation:
The WeatherTower class uses a private constructor and provides a static getInstance() method to ensure that only one instance can be created:
```java
public class WeatherProvider {
	String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};
	private static WeatherProvider weatherProvider = new WeatherProvider();

	private WeatherProvider(){}
	public static WeatherProvider getWeatherProvider(){
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates p_coordinates){
		String weatheString = weather[(int) (Math.random() * weather.length)];
		return (weatheString);
	}
}
```
### Observer Pattern
The Observer design pattern is used to establish a relationship between the WeatherTower and the various Aircraft objects. The WeatherTower acts as the subject, while the Aircraft classes act as observers. This pattern allows the WeatherTower to notify all registered aircraft whenever the weather changes.

#### How it works:

Aircraft objects register with the WeatherTower during initialization.
The WeatherTower invokes the updateConditions() method on each registered aircraft whenever the weather changes.
Each aircraft handles the weather update based on its specific behavior.
#### Implementation:

Subject: WeatherTower
Observers: Baloon, Helicopter, JetPlane
Example:
```java
public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
```
### Factory Pattern
The Factory design pattern is used to create instances of different types of aircraft without specifying their exact class. This decouples the object creation process from the client code, making it easier to extend and maintain.

#### How it works:

A central AircraftFactory class is responsible for creating instances of Baloon, Helicopter, and JetPlane.
The type of aircraft is determined at runtime based on input from the scenario file.
#### Implementation:
```java
public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "Baloon":
                return new Baloon(name, longitude, latitude, height);
            case "Helicopter":
                return new Helicopter(name, longitude, latitude, height);
            case "JetPlane":
                return new JetPlane(name, longitude, latitude, height);
            default:
                throw new IllegalArgumentException("Invalid aircraft type");
        }
    }
}
```
#### Benefits:

Centralizes and simplifies object creation.
Enhances code readability and scalability.

## How to run
Clone the repository. Run:
```bash
cd src
find * -name "*.java" > sources.txt
javac @sources.txt 
java com.avj.AvjMain scenario.txt
```
or
```bash
javac -d out $(find src -name "*.java")
java -cp out com.avj.AvjMain src/scenario.txt
```
to clean up:
```bash
rm $(find * -name "*.class")
```
