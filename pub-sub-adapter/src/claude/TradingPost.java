package claude;

import java.util.ArrayList;
import java.util.List;

public class TradingPost {
  private final List<TradeListener> listeners;

  public TradingPost() {
    listeners = new ArrayList<>();
  }

  public void executeTrade(Item item, int quantity, boolean isBuying) {
    for (TradeListener listener : listeners) {
      listener.notifyTrade(item, quantity, isBuying);
    }
    System.out.println("Trade executed: " + item.name());
  }

  public void subscribe(TradeListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException();
    } else {
      listeners.add(listener);
    }
  }
}