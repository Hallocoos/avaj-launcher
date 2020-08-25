package src.simulator;

import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

import src.aircraft.*;
import src.simulator.interfaces.Flyable;

class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] arg) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null) {
				try {
					int simulations = Integer.parseInt(line.split(" ")[0]);
					if (simulations < 1) {
						System.out.println("Invalid simulations count " + simulations);
						System.exit(1);
					}
					while ((line = reader.readLine()) != null) {
						String type = line.split(" ")[0];
						String name = line.split(" ")[1];
						int longitude = Integer.parseInt(line.split(" ")[2]);
						int latitude = Integer.parseInt(line.split(" ")[3]);
						int height = Integer.parseInt(line.split(" ")[4]);
						if (name.length() > 0 && (type.equals("JetPlane") || type.equals("Helicopter") || type.equals("Baloon"))) {
							Flyable flyable = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
							flyables.add(flyable);
						} else {
							System.out.println("Specify Simulation file");
							System.exit(0);
						}
					}
					for (Flyable flyable : flyables) {
						flyable.registerTower(weatherTower);
					}
					for (int i = 1; i <= simulations; i++) {
						weatherTower.changeWeather();
					}
				} catch (NumberFormatException e) {
					System.out.println("There was an error reading the file " + arg[0]);
				}
				reader.close();
			} else
				System.out.println("File is empty: " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify Simulation file");
		} finally {
			Logger.closeWriter();
		}
	}
}
