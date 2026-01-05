package rpgshopping.answersrecent;

import java.util.Map;
import rpgshopping.Backpack;
import rpgshopping.Item;

public class BarteringTable {
  private final Backpack delegate;

  public BarteringTable(Backpack delegate, double limit) {
    this.delegate = delegate;
    this.delegate.addCurrency(limit);
  }

  enum Status {
    PLAYER, SHOPKEEP, BOTH;
  }

  public void purchaseItem(Map<Item, Integer> items) {
    for (Item item : items.keySet()) {
      delegate.addItemToInventory(item, items.get(item));
    }
  }

  public void sellItem(Map<Item, Integer> items) {
    for (Item item : items.keySet()) {
      delegate.addItemToInventory(new Item(item.name(), item.price() * -1),
          items.get(item));
    }
  }

  public Status tradeStatus() {
    double gold = currentShopkeepCurrency();
    if (gold < 0) {
      return Status.PLAYER;
    }
    if (gold > 0) {
      return Status.SHOPKEEP;
    } else {
      return Status.BOTH;
    }
  }

  public double currentShopkeepCurrency() {
    double gold = delegate.backpackWorth();
    if (gold < 0) {
      return 0;
    } else {
      return gold;
    }
  }
}
