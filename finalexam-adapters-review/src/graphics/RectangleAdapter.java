package graphics;

public class RectangleAdapter extends LegacyRectangle implements Shape {

  public RectangleAdapter(double width, double height) {
    super(width, height);
  }

  @Override
  public void draw() {
    render();
  }

  @Override
  public double getArea() {
    return calculateArea();
  }
}
