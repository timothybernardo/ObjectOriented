class Thermostat implements TemperatureListener {
  private String location;

  public Thermostat(String location) {
    this.location = location;
  }

  public void adjustForTemperature(double outsideTemp) {
    if (outsideTemp > 75) {
      System.out.println("Thermostat (" + location + "): AC activated");
    } else if (outsideTemp < 60) {
      System.out.println("Thermostat (" + location + "): Heater activated");
    } else {
      System.out.println("Thermostat (" + location + "): System on standby");
    }
  }

  @Override
  public void notifyTemperatureChange(double temp) {
    adjustForTemperature(temp);
  }
}