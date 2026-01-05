package graphics;

public class CircleAdapter implements Shape {
  private LegacyCircle circle;

  public CircleAdapter(LegacyCircle circle) {
    this.circle = circle;
  }

  @Override
  public void draw() {
    circle.display();
  }

  @Override
  public double getArea() {
    return circle.computeArea();
  }
}
