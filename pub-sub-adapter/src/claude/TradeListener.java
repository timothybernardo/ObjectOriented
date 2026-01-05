package claude;

public interface TradeListener {
  void notifyTrade(Item item, int quantity, boolean isBuying);
}
