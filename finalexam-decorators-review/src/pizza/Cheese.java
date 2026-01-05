package pizza;

public class Cheese extends ToppingDecorator {
  public Cheese(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String description() {
    return pizza.description() + ", cheese";
  }

  @Override
  public double price() {
    return this.pizza.price() + 1.50;
  }

}
