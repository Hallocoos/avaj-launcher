package src.weather;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  public Coordinates(int longitude, int latitude, int height) {
    this.longitude = longitude;
    this.latitude = latitude;
    if (height > 0)
      this.height = height;
    else
      this.height = 0;
  }

  public int getLongitude() {
    return this.longitude;
  }

  public int getLatitude() {
    return this.latitude;
  }

  public int getHeight() {
    return this.height;
  }

  public String toString() {
    return String.valueOf(this.longitude) + "\t" + String.valueOf(this.latitude) + "\t" + String.valueOf(this.height);
  }
}