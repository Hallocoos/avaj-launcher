package src.weather;

import java.util.*;

public class WeatherProvider {
  WeatherProvider weatherProvider;
  String[] weather = {"Rain", "Fog", "Sun", "Snow"};
  String currWeather;

  private WeatherProvider() {
    int randomNumber = new Random().nextInt(weather.length);
    this.currWeather = this.weather[randomNumber];
  }

  public void getProvider() {

  }

  public String getCurrentWeather(Coordinates coordinates) {
    return "asdf";
  }
}