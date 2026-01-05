package graphics;

public class LegacyCircle {
  private double radius;

  public LegacyCircle(double radius) {
    this.radius = radius;
  }

  public void display() {
    System.out.println("Drawing circle with radius: " + radius);
  }

  public double computeArea() {
    return Math.PI * radius * radius;
  }
}
