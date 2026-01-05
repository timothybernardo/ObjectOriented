package inclass;

import claude.Item;
import java.util.ArrayList;
import java.util.List;

public class TradeActionsSubscriberImpl implements TradeActionsSubscriber {
  private List<TradesListener> subs;
  private final TradeActions delegate;

  public TradeActionsSubscriberImpl(TradeActions delegate) {
    if (delegate == null) {
      throw new IllegalArgumentException();
    }
    this.delegate = delegate;
    this.subs = new ArrayList<>();
  }

  @Override
  public void requestItemForTrade(Item item, int amt) {
    delegate.requestItemForTrade(item, amt);

    for (TradesListener listener : subs) {
      listener.notifyRequestItem(item, amt);
    }
  }

  @Override
  public void putUpItemForTrade(Item item, int amt) {
    delegate.putUpItemForTrade(item, amt * -1);

    for (TradesListener listener : subs) {
      listener.notifyPutUpItem(item, amt);
    }
  }

  @Override
  public void subscribe(TradesListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException();
    } else {
      subs.add(listener);
    }
  }
}
