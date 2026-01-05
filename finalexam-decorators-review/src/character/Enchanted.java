package character;

public class Enchanted extends AbilityDecorator {
  public Enchanted(Character character) {
    super(character);
  }

  @Override
  public int attackPower() {
    return character.attackPower() * 2;
  }

  @Override
  public String description() {
    return "Enchanted " + character.description();
  }
}
