package src.aircraft;

import src.weather.Coordinates;
import src.simulator.WeatherTower;
import src.simulator.interfaces.*;
import src.simulator.Logger;

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
        this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput(
              "Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput(
              "Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
        break;
      case "Rain":
        this.coordinates = new Coordinates(longitude + 5, latitude, height);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
        break;
      case "Fog":
        this.coordinates = new Coordinates(longitude + 1, latitude, height);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput(
              "Baloon#" + this.name + "(" + this.id + "): Too bad the few is ruined up here with all the fog.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput(
              "Baloon#" + this.name + "(" + this.id + "): Too bad the few is ruined up here with all the fog.");
        break;
      case "Snow":
        this.coordinates = new Coordinates(longitude, latitude, height - 12);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're  gonna crash.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're  gonna crash.");
        break;
    }
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    this.weatherTower.register(this);
    Logger.writeOutput("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
  }

  public void unregisterTower() {
    Logger.writeOutput("Baloon#" + this.name + "(" + this.id + "): I am landing. Coordinates: " + this.coordinates);
    Logger.writeOutput("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
  }
}