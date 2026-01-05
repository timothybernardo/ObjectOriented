package claude;

class AchievementSystem implements TradeListener {
  void checkTradeAchievements(Item item, double totalValue) {
    if (totalValue > 100) {
      System.out.println("Achievement: Big Spender!");
    }
  }

  @Override
  public void notifyTrade(Item item, int quantity, boolean isBuying) {
    checkTradeAchievements(item, item.price() * quantity);
  }
}