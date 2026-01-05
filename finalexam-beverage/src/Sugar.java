public class Sugar extends BeverageDecorator {
  public Sugar(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return beverage.cost() + 2;
  }
}
