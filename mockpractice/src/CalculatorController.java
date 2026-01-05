import java.io.IOException;
import java.util.Scanner;

public class CalculatorController {
  private final Readable in;
  private final Appendable out;

  public CalculatorController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  public void run(Calculator calc) throws IOException {
    Scanner scan = new Scanner(in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int result = calc.add(a, b);
    out.append("Result: " + result + "\n");
  }
}
