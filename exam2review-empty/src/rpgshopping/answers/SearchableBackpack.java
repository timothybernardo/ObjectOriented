package rpgshopping.answers;

import java.util.List;
import rpgshopping.Backpack;
import rpgshopping.Item;

public interface SearchableBackpack extends Backpack {
  List<Item> search(Criteria crit);
}
