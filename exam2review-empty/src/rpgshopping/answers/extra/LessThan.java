package rpgshopping.answers.extra;

import rpgshopping.Item;
import rpgshopping.answers.Criteria;

public class LessThan implements Criteria {
  private final double value;

  public LessThan(double value) {
    this.value = value;
  }

  @Override
  public boolean matches(Item item) {
    return item.price() < value;
  }
}
