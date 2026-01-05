package answers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import rpgshopping.Item;
import rpgshopping.answersrecent.LessThan;
import rpgshopping.answersrecent.SearchableBackpack;
import rpgshopping.answersrecent.StartWith;

public class HelperMethodNew {
  public void testHelper(SearchableBackpack backpack) {
    assertTrue(backpack.contents().isEmpty());
    Item sapphire = new Item("Sapphire", 300);
    backpack.addItemToInventory(sapphire, 3);
    Item ruby = new Item("Ruby", 150);
    backpack.addItemToInventory(ruby, 1);
    List<Item> onlyRuby = backpack.search(new LessThan(200));
    List<Item> onlyRubyActual = new ArrayList<>();
    onlyRubyActual.add(ruby);
    assertEquals(onlyRubyActual, onlyRuby);
    List<Item> itemsP = backpack.search(new StartWith("P"));
    assertTrue(itemsP.isEmpty());
  }
}
