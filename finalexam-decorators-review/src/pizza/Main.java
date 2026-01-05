package pizza;

public class Main {
  public static void main(String[] args) {
    Pizza pizza = new BasePizza();
    System.out.println(pizza.description());
    Pizza pepperoni = new Pepperoni(new BasePizza());
    System.out.println(pepperoni.description());
    System.out.println(new SpicyPepperoni(new Mushrooms(new ThinCrust()), 2).description());
  }
}
