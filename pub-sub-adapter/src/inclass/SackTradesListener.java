package inclass;

import claude.Item;

public class SackTradesListener implements TradesListener {
  private final Sack delegate;

  public SackTradesListener(Sack delegate) {
    if (delegate == null) {
      throw new IllegalArgumentException();
    }
    this.delegate = delegate;
  }

  @Override
  public void notifyRequestItem(Item item, int amt) {
    delegate.addItem(item, amt);
  }

  @Override
  public void notifyPutUpItem(Item item, int amt) {
    delegate.addItem(item, -1 * amt);
  }
}
