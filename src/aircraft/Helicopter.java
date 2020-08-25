package src.aircraft;

import src.weather.Coordinates;
import src.simulator.Logger;
import src.simulator.WeatherTower;
import src.simulator.interfaces.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
		case "Sun":
			this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
			if (height > 100) {
				this.coordinates = new Coordinates(longitude, latitude, 100);
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): This is hot.");
			} else if (height == 0 || height < 0) {
				this.coordinates = new Coordinates(longitude, latitude, 0);
				weatherTower.logItem(this);
				this.unregisterTower();
			} else
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): This is hot.");
			break;
		case "Rain":
			this.coordinates = new Coordinates(longitude + 5, latitude, height);
			if (height > 100) {
				this.coordinates = new Coordinates(longitude, latitude, 100);
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): I'm safe from the rain.");
			} else if (height == 0 || height < 0) {
				this.coordinates = new Coordinates(longitude, latitude, 0);
				weatherTower.logItem(this);
				this.unregisterTower();
			} else
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): I'm safe from the rain.");
			break;
		case "Fog":
			this.coordinates = new Coordinates(longitude + 1, latitude, height);
			if (height > 100) {
				this.coordinates = new Coordinates(longitude, latitude, 100);
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): I can't see through this fog");
			} else if (height == 0 || height < 0) {
				this.coordinates = new Coordinates(longitude, latitude, 0);
				weatherTower.logItem(this);
				this.unregisterTower();
			} else
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "): I can't see through this fog");
			break;
		case "Snow":
			this.coordinates = new Coordinates(longitude, latitude, height - 12);
			if (height > 100) {
				this.coordinates = new Coordinates(longitude, latitude, 100);
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "):  My rotor is going to freeze!");
			} else if (height == 0 || height < 0) {
				this.coordinates = new Coordinates(longitude, latitude, 0);
				weatherTower.logItem(this);
				this.unregisterTower();
			} else
				Logger.writeOutput("Helicopter#" + this.name + "(" + this.id + "):  My rotor is going to freeze!");
			break;
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Logger.writeOutput("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
	}

	public void unregisterTower() {
		Logger.writeOutput(
				"Helicopter#" + this.name + "(" + this.id + "): I am landing. Coordinates: " + this.coordinates);
		Logger.writeOutput(
				"Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
	}
}