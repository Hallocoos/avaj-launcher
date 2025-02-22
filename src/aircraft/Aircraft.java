package src.aircraft;

import src.weather.Coordinates;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		idCounter = nextId();
		this.id = idCounter;
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return (++idCounter);
	}

	public String toString() {
		return this.id + "\t" + this.name + "\t" + this.coordinates;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	public Coordinates getCoordinates() {
		return this.coordinates;
	}
}