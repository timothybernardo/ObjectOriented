package answers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import rpgshopping.Item;
import rpgshopping.answers2.SearchableBackpack;

public class HelperMethod2 {
  private void helper(SearchableBackpack backpack) {
    assertTrue(backpack.contents().isEmpty());
    Item sapphire = new Item("Sapphire", 300);
    Item ruby = new Item("Ruby", 150);
    backpack.addItemToInventory(sapphire, 3);
    backpack.addItemToInventory(ruby, 1);
    List<Item> lessThan200 = backpack.search(new LessThan(200));
    List<Item> onlyRuby = new ArrayList<>();
    onlyRuby.add(ruby);
    assertEquals(onlyRuby, lessThan200);
    List<Item> onlyP = backpack.search(StartsWith("P"));
    assertTrue(onlyP.isEmpty());
  }
}
