class PhoneApp implements TemperatureListener {
  private String userName;

  public PhoneApp(String user) {
    this.userName = user;
  }

  public void temperatureChanged(double temp) {
    if (temp > 85) {
      System.out.println("Phone (" + userName + "): ⚠️ Heat Advisory!");
    } else if (temp < 32) {
      System.out.println("Phone (" + userName + "): ❄️ Freeze Warning!");
    } else {
      System.out.println("Phone (" + userName + "): Temperature is " + temp + "°F");
    }
  }

  @Override
  public void notifyTemperatureChange(double temp) {
    temperatureChanged(temp);
  }
}