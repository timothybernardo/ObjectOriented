package smarthome;

public class Light implements MotionListener {
  @Override
  public void onMotionDetected(String room) {
    System.out.println("Lights: Turning on in " + room);
  }
}
