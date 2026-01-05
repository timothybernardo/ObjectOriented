package pizza;

public abstract class ToppingDecorator implements Pizza {
  protected Pizza pizza;

  public ToppingDecorator(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public double price() {
    return pizza.price();
  }

  @Override
  public String description() {
    return pizza.description();
  }
}
