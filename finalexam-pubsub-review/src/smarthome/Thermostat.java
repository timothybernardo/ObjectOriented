package smarthome;

public class Thermostat implements TemperatureListener {


  @Override
  public void onTemperatureChange(double temp) {
    if (temp > 80) {
      System.out.println("Thermostat: Adjusting to cool down (" + temp + " degrees)");
    } else if (temp < 60) {
      System.out.println("Thermostat: Adjusting to heat up (" + temp + " degrees)");
    } else {
      System.out.println("Thermostat: Temperature normal (" + temp + " degrees)");
    }
  }
}
