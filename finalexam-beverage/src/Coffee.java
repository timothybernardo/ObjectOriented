public class Coffee implements Beverage {

  private final Size size;
  private final double cost;

  public Coffee(Size size) {
    this.size = size;
    this.cost = 5;
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
