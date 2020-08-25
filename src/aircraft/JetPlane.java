package src.aircraft;

import src.weather.Coordinates;
import src.simulator.Logger;
import src.simulator.WeatherTower;
import src.simulator.interfaces.*;

public class JetPlane extends Aircraft implements Flyable {
  private WeatherTower weatherTower;

  public JetPlane(String name, Coordinates coordinates) {
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
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): Need a visor to block out the sun.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): Need a visor to block out the sun.");
        break;
      case "Rain":
        this.coordinates = new Coordinates(longitude + 5, latitude, height);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput(
              "JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput(
              "JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
        break;
      case "Fog":
        this.coordinates = new Coordinates(longitude + 1, latitude, height);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): Fog is to far down to bother me.");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): Fog is to far down to bother me.");
        break;
      case "Snow":
        this.coordinates = new Coordinates(longitude, latitude, height - 12);
        if (height > 100) {
          this.coordinates = new Coordinates(longitude, latitude, 100);
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
        } else if (height == 0 || height < 0) {
          this.coordinates = new Coordinates(longitude, latitude, 0);
          weatherTower.logItem(this);
          this.unregisterTower();
        } else
          Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
        break;
    }
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    this.weatherTower.register(this);
    Logger.writeOutput("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
  }

  public void unregisterTower() {
    Logger.writeOutput("JetPlane#" + this.name + "(" + this.id + "): I am landing. Coordinates: " + this.coordinates);
    Logger.writeOutput("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
  }
}