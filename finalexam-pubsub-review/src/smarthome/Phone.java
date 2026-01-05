package smarthome;

public class Phone implements MotionListener, TemperatureListener {
  @Override
  public void onMotionDetected(String room) {
    System.out.println("Phone: Alert! Motion in " + room);
  }

  @Override
  public void onTemperatureChange(double temp) {
    if (temp > 80) {
      System.out.println("Warning! Temperature is " + temp);
    } else if (temp < 60) {
      System.out.println("Warning! Temperature is " + temp);
    }
  }
}
