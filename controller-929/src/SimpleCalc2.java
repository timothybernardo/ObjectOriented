import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator
 */
public class SimpleCalc2 {
  public static void main(String[] args) {
    int num1, num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", new Calculator().add(num1, num2));
    // system.out.printf is the view, but it should be in a diff class
  }
}

interface IcCalculator {
  int add(int num1, int num2);
} // model

class Calculator implements IcCalculator {
  public int add(int num1, int num2) {
    return num1 + num2;
  }
}

