package rpgshopping.answersrecent;

import rpgshopping.Item;

public class StartWith implements SearchStrategy {
  private final String letter;

  public StartWith(String letter) {
    this.letter = letter;
  }

  @Override
  public boolean matches(Item item) {
    return item.name().startsWith(letter);
  }
}
