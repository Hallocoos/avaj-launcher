package src.simulator;

import src.simulator.interfaces.Flyable;
// import src.weather.WeatherProvider;
import java.util.*;

public abstract class Tower {
  private List<Flyable> observers = new ArrayList<Flyable>();

  public void register(Flyable flyable) {
    observers.add(flyable);
  }

  public void unregister(Flyable flyable) {
    observers.remove(flyable);
  }

  protected void conditionsChanged() {
    // update aircraft movement
    // loop through observers and call their weather movement function that updates their coords
  }
}