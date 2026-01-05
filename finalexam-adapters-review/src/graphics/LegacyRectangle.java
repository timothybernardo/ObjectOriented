package graphics;

public class LegacyRectangle {
  private double width;
  private double height;

  public LegacyRectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public void render() {
    System.out.println("Drawing rectangle: " + width + " x " + height);
  }

  public double calculateArea() {
    return width * height;
  }
}
