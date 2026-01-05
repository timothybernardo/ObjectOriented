import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator
 */
public class SimpleCalc1 {
  public static void main(String[] args) {
    int num1, num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", num1 + num2); // num1 + num2 is model
    // entire system.out.printf is the view
    // everything else is controller!
  }
}
