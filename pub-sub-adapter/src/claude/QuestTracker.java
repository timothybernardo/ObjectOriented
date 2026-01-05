package claude;

class QuestTracker implements TradeListener {
  void updateQuestProgress(Item item, int quantity) {
    System.out.println("Quest updated: " + quantity + " " + item.name());
  }

  @Override
  public void notifyTrade(Item item, int quantity, boolean isBuying) {
    updateQuestProgress(item, quantity);
  }
}