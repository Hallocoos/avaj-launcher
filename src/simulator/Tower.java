package src.simulator;

import src.simulator.interfaces.Flyable;
// import src.weather.WeatherProvider;
import java.util.*;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	private List<Flyable> removeItems = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	public void logItem(Flyable flyable) {
		removeItems.add(flyable);
	}

	public void removeItems() {
		for (Flyable flyable : removeItems) {
			observers.remove(flyable);
		}
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		this.removeItems();
	}
}