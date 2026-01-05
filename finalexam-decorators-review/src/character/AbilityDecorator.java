package character;

public abstract class AbilityDecorator implements Character {
  protected Character character;

  public AbilityDecorator(Character character) {
    this.character = character;
  }

  @Override
  public int attackPower() {
    return character.attackPower();
  }

  @Override
  public String description() {
    return character.description();
  }
}
