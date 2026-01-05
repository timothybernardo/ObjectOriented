package character;

public class Warrior implements Character {
  @Override
  public int attackPower() {
    return 15;
  }

  @Override
  public String description() {
    return "Warrior";
  }
}
