package rpgshopping.answers.extra;

import rpgshopping.Item;
import rpgshopping.answers.Criteria;

public class StartsWith implements Criteria {
  private final String letter;

  public StartsWith(String letter) {
    this.letter = letter;
  }

  @Override
  public boolean matches(Item item) {
    return item.name().startsWith(letter);
  }
}
