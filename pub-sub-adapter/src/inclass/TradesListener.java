package inclass;

import claude.Item;

public interface TradesListener {
  void notifyRequestItem(Item item, int amt);

  void notifyPutUpItem(Item item, int amt);
}
