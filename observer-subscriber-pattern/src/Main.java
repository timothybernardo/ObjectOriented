public class Main {
  public static void main(String[] args) {
    WeatherStation station = new WeatherStation();

    PhoneApp johnsPhone = new PhoneApp("John");
    Thermostat homeThermostat = new Thermostat("Living Room");
    NewsWebsite cnnWeather = new NewsWebsite("CNN");

    station.subscribe(johnsPhone);
    station.subscribe(homeThermostat);
    station.subscribe(cnnWeather);
    // Test temperature changes
    station.updateTemperature(90.0);
    System.out.println();
    station.updateTemperature(28.0);
  }
}