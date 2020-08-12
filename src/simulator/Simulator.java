package src.simulator;

import java.io.*;
// import java.util.*;
// import src.simulator.interfaces.Flyable;
// import src.aircraft.*;

public class Simulator {
  // private static WeatherTower weatherTower;
  // private static List<Flyable> flyables = new ArrayList<Flyable>();

  public static void main(String[] arg) throws InterruptedException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
      String line = reader.readLine();
      if (line != null) {
        System.out.println(line);
        // weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(line.split(" ")[0]);
        if (simulations < 1) {
          System.out.println("Invalid simulations count " + simulations);
          System.exit(1);
        }
        while ((line = reader.readLine()) != null) {
          // Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
          //     Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
          //     Integer.parseInt(line.split(" ")[4]));
          // flyables.add(flyable);
          System.out.println(line);
        }
        // for (Flyable flyable : flyables) {
        //   flyable.registerTower(weatherTower);
        // }
        // for (int i = 1; i <= simulations; i++) {
        //   weatherTower.changeWeather();
        // }
      }
      reader.close();
      // } catch (FileNotFoundExeption e) {
      // System.out.println("Couldn\'t find file " + arg[0]);
    } catch (IOException e) {
      System.out.println("There was an error reading the file " + arg[0]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Specify Simulation file");
    }
    // finally {
    // Logger.getLogger().close();
    // }
  }
}