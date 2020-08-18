package src.aircraft;

import src.weather.Coordinates;
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
      case "Rain":
        this.coordinates = new Coordinates(longitude + 5, latitude, height);
      case "Fog":
        this.coordinates = new Coordinates(longitude + 1, latitude, height);
      case "Snow":
        this.coordinates = new Coordinates(longitude, latitude, height - 12);
    }
  }
  
  public void registerTower(WeatherTower weatherTower) {
    weatherTower.register(this);
  }
}