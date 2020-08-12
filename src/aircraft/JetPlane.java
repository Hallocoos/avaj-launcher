package src.aircraft;

import src.weather.Coordinates;
import src.simulator.WeatherTower;
import src.simulator.interfaces.*;

public class JetPlane extends Aircraft implements Flyable {
  private WeatherTower weatherTower;

  public JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {

  }
}