package pizza;

public class ThinCrust implements Pizza {
  private String desc;
  private double price;

  public ThinCrust() {
    this.desc = "Thin crust pizza";
    this.price = 9.00;
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
