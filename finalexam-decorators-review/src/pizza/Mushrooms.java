package pizza;

public class Mushrooms extends ToppingDecorator {
  public Mushrooms(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String description() {
    return pizza.description() + ", mushrooms";
  }

  @Override
  public double price() {
    return this.pizza.price() + 1.25;
  }

}
