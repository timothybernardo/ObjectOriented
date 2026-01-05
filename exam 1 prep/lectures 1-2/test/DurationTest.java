import static org.junit.Assert.assertEquals;

import lecture1and2.Duration;
import lecture1and2.DurationImpl;
import org.junit.Test;

public class DurationTest {
  @Test
  public void testValidConstruction() {
    Duration example = new DurationImpl(1, 1, 1);
    assertEquals(60 * 60 + 60 + 1, example.inSeconds());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructionFirstParam() {
    Duration example = new DurationImpl(-1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructionSecondParam() {
    Duration example = new DurationImpl(1, -1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructionThirdParam() {
    Duration example = new DurationImpl(1, 1, -1);
  }
}
