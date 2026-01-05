package inclass;

import claude.Item;

public interface TradeActions {
  void requestItemForTrade(Item item, int amt);

  void putUpItemForTrade(Item item, int amt);
}