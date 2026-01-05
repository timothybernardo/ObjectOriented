package pizza;

public class Pepperoni extends ToppingDecorator {
  public Pepperoni(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String description() {
    return pizza.description() + ", pepperoni";
  }

  @Override
  public double price() {
    return this.pizza.price() + 2.00;
  }

}
