package rpgshopping.answers;

import java.util.Map;
import rpgshopping.Backpack;
import rpgshopping.CharacterBackpack;
import rpgshopping.Item;

public class BarteringTable {
  private final Backpack adaptee;

  public BarteringTable(double gold) {
    this.adaptee = new CharacterBackpack();
    this.adaptee.addCurrency(gold);
  }

  public void purchaseItem(Map<Item, Integer> items) {
    for (Item key : items.keySet()) {
      this.adaptee.addItemToInventory(key, items.get(key));
    }
  }

  public void sellItem(Map<Item, Integer> items) {
    for (Item key : items.keySet()) {
      this.adaptee.addItemToInventory(new Item(key.name(), -1 * key.price()),
          items.get(key));
    }
  }

  public Status tradeStatus() {
    double worth = this.adaptee.backpackWorth();
    if (worth > 0) {
      return Status.SHOPKEEP;
    } else if (worth < 0) {
      return Status.PLAYER;
    }
    return Status.BOTH;
  }

  public double currentShopkeepCurrency() {
    double worth = this.adaptee.backpackWorth();
    if (worth < 0) {
      return 0;  // Return 0 if shopkeep would go negative
    }
    return worth;
  }
}
