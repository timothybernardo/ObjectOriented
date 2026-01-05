import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;

public class CalculatorControllerTest {
  @Test
  public void testControllerWithCalculator() throws IOException {
    Readable input = new StringReader("3 4");
    Appendable output = new StringBuilder();
    CalculatorController controller = new CalculatorController(input, output);
    controller.run(new RealCalculator());
    assertEquals("Result: 7\n", output.toString());
  }

  private static class MockCalculator implements Calculator {
    private final StringBuilder log;

    private MockCalculator(StringBuilder log) {
      this.log = log;
    }

    @Override
    public int add(int a, int b) {
      log.append("Received: " + a + " " + b + "\n");
      return 0;
    }
  }

  @Test
  public void testControllerPassesInputCorrectly() throws IOException {
    Readable input = new StringReader("10 20");
    Appendable fakeOutput = new StringBuilder();
    StringBuilder log = new StringBuilder();
    Calculator calculator = new MockCalculator(log);
    CalculatorController controller = new CalculatorController(input, fakeOutput);
    controller.run(calculator);
    assertEquals("Received: 10 20\n", log.toString());
  }
}
