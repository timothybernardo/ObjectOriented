package character;

public class Cursed extends AbilityDecorator implements Curse {
  private final String name;

  public Cursed(Character character, String name) {
    super(character);
    this.name = name;
  }

  @Override
  public int attackPower() {
    return character.attackPower() / 2;
  }

  @Override
  public String description() {
    return "Cursed " + character.description();
  }

  @Override
  public String curseName() {
    return name;
  }
}
