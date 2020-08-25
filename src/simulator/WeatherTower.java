package src.simulator;

import src.weather.*;

public class WeatherTower extends Tower {
	public void changeWeather() {
		this.conditionsChanged();
	}

	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
}