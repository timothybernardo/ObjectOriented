import java.util.ArrayList;
import java.util.List;

class WeatherStation {
  private double currentTemp;
  private List<TemperatureListener> listeners;

  public WeatherStation() {
    this.currentTemp = 70.0;
    listeners = new ArrayList<>();
  }

  public void subscribe(TemperatureListener listener) {
    listeners.add(listener);
  }


  public void updateTemperature(double newTemp) {
    this.currentTemp = newTemp;
    System.out.println("Station: Temperature updated to " + newTemp + "°F");
    for (TemperatureListener listener : listeners) {
      listener.notifyTemperatureChange(newTemp);
    }
  }


}