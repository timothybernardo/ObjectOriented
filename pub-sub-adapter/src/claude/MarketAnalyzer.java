package claude;

class MarketAnalyzer implements TradeListener {
  void recordTransaction(String itemName, int quantity, double priceEach) {
    System.out.println("Market data recorded: " + itemName);
  }

  @Override
  public void notifyTrade(Item item, int quantity, boolean isBuying) {
    recordTransaction(item.name(), quantity, item.price());
  }
}