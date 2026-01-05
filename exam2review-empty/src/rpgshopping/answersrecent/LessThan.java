package rpgshopping.answersrecent;

import rpgshopping.Item;

public class LessThan implements SearchStrategy {
  private final double limit;

  public LessThan(double limit) {
    this.limit = limit;
  }

  @Override
  public boolean matches(Item item) {
    return item.price() < limit;
  }
}
