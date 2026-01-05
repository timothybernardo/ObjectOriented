class NewsWebsite implements TemperatureListener {
  private String siteName;

  public NewsWebsite(String name) {
    this.siteName = name;
    
  }

  public void updateWeatherSection(double temp) {
    System.out.println("Website (" + siteName + "): Weather widget updated - " + temp + "°F");
  }

  @Override
  public void notifyTemperatureChange(double temp) {
    updateWeatherSection(temp);
  }
}