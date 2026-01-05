public class Tea implements Beverage {
  private final Size size;
  private final double cost;

  public Tea(Size size) {
    this.size = size;
    this.cost = 4;
  }

  @Override
  public Size getSize() {
    return this.size;
  }

  @Override
  public double cost() {
    return this.cost;
  }
}
