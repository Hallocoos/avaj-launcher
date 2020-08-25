package src.weather;

import java.util.*;

public class WeatherProvider {
  private static WeatherProvider weatherProvider = null;
  private String[] weather = { "Rain", "Fog", "Sun", "Snow" };

  private WeatherProvider() {
  }

  public static WeatherProvider getProvider() {
    if (weatherProvider == null)
      weatherProvider = new WeatherProvider();
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    return this.weather[new Random().nextInt(weather.length)];
  }
}