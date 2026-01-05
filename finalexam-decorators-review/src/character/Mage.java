package character;

public class Mage implements Character {
  @Override
  public int attackPower() {
    return 10;
  }

  @Override
  public String description() {
    return "Mage";
  }
}
