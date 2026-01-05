package answers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import rpgshopping.Item;
import rpgshopping.answers.extra.LessThan;
import rpgshopping.answers.SearchableBackpack;
import rpgshopping.answers.extra.StartsWith;

public class HelperMethod {
  private void helperMethod(SearchableBackpack pack) {
    assertTrue(pack.contents().isEmpty());
    Item sapphire = new Item("Sapphire", 300);
    pack.addItemToInventory(sapphire, 3);
    Item ruby = new Item("Ruby", 150);
    pack.addItemToInventory(ruby, 1);
    List<Item> lessThan = pack.search(new LessThan(200));
    List<Item> onlyRuby = new ArrayList<>();
    onlyRuby.add(ruby);
    assertEquals(onlyRuby, lessThan);
    List<Item> onlyP = pack.search(new StartsWith("P"));
    assertTrue(onlyP.isEmpty());
  }
}
