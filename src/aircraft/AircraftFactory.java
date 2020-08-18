package src.aircraft;

import src.weather.*;
import src.simulator.interfaces.Flyable;

public abstract class AircraftFactory {
  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
    Coordinates coordinates = new Coordinates(longitude, latitude, height);
    Flyable newAircraft;
    switch (type) {
      case "Helicopter":
        newAircraft = new Helicopter(name, coordinates);
        return newAircraft;
      case "Baloon":
        newAircraft = new Baloon(name, coordinates);
        return newAircraft;
      case "JetPlane":
        newAircraft = new JetPlane(name, coordinates);
        return newAircraft;
    }
    return null;
  }
}