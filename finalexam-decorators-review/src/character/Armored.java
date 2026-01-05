package character;

public class Armored extends AbilityDecorator {
  public Armored(Character character) {
    super(character);
  }

  @Override
  public int attackPower() {
    return character.attackPower() + 5;
  }

  @Override
  public String description() {
    return "Armored " + character.description();
  }
}
