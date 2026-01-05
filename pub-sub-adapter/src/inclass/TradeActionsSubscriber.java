package inclass;

public interface TradeActionsSubscriber extends TradeActions {
  void subscribe(TradesListener listener);
}
