package pizza;

public class SpicyPepperoni extends ToppingDecorator implements Spicy {
  private int level;

  public SpicyPepperoni(Pizza pizza, int level) {
    super(pizza);
    this.level = level;
  }

  @Override
  public double price() {
    return pizza.price() + 2.50;
  }

  @Override
  public String description() {
    return pizza.description() + ", spicy pepperoni";
  }

  @Override
  public int spicinessLevel() {
    return level;
  }
}
