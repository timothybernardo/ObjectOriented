public abstract class BeverageDecorator implements Beverage {
  protected final Beverage beverage;

  public BeverageDecorator(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return beverage.cost();
  }

  @Override
  public Size getSize() {
    return beverage.getSize();
  }
}
