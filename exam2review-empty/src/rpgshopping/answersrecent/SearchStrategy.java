package rpgshopping.answersrecent;

import java.util.List;
import rpgshopping.Item;

public interface SearchStrategy {
  boolean matches(Item item);
}
