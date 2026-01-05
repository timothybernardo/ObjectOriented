package character;

public class Flying extends AbilityDecorator {
  public Flying(Character character) {
    super(character);
  }

  @Override
  public int attackPower() {
    return character.attackPower() + 3;
  }

  @Override
  public String description() {
    return "Flying " + character.description();
  }
}
