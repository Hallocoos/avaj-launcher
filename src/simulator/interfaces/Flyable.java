package src.simulator.interfaces;

import src.simulator.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}