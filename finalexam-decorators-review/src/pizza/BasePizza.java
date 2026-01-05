package pizza;

public class BasePizza implements Pizza {
  private String desc;
  private double price;

  public BasePizza() {
    this.desc = "Plain pizza";
    this.price = 8.00;
  }

  @Override
  public String description() {
    return desc;
  }

  @Override
  public double price() {
    return price;
  }
}
