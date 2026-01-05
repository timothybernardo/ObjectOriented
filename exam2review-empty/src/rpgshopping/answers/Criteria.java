package rpgshopping.answers;

import rpgshopping.Item;

public interface Criteria {
  boolean matches(Item item);
}
