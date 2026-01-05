package character;

public class Main {
  public static void main(String[] args) {
    // Armored Warrior
    Character c1 = new Armored(new Warrior());
    System.out.println(c1.description());  // "Armored Warrior"
    System.out.println(c1.attackPower());  // 20

    // Cursed Warrior - access curseName() both ways
    Curse cursed = new Cursed(new Warrior(), "Doom");
    System.out.println(((Character) cursed).description());  // "Cursed Warrior"
    System.out.println(cursed.curseName());  // "Doom"

    // Or with casting
    Character c2 = new Cursed(new Warrior(), "Doom");
    System.out.println(((Curse) c2).curseName());  // "Doom"
  }
}

