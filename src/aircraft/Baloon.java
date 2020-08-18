package src.aircraft;

import src.weather.Coordinates;
import src.simulator.WeatherTower;
import src.simulator.interfaces.*;

public class Baloon extends Aircraft implements Flyable {
  private WeatherTower weatherTower;

  public Baloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    int longitude = this.coordinates.getLongitude();
    int latitude = this.coordinates.getLatitude();
    int height = this.coordinates.getHeight();
    String weather = weatherTower.getWeather(coordinates);
    switch (weather) {
      case "Sun":
        this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
      case "Rain":
        this.coordinates = new Coordinates(longitude, latitude, height - 5);
      case "Fog":
        this.coordinates = new Coordinates(longitude, latitude, height - 3);
      case "Snow":
        this.coordinates = new Coordinates(longitude, latitude, height - 15);
    }
    longitude = this.coordinates.getLongitude();
    latitude = this.coordinates.getLatitude();
    height = this.coordinates.getHeight();
    if (longitude > 100)
      this.coordinates = new Coordinates(100, latitude, height);
    if (latitude > 100)
      this.coordinates = new Coordinates(longitude, 100, height);
    if (height > 100)
      this.coordinates = new Coordinates(longitude, latitude, 100);
  }

  public void registerTower(WeatherTower weatherTower) {
    weatherTower.register(this);
  }
}