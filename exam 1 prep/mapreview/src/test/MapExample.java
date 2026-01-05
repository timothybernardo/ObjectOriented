import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MapExample {
  @Test
  public void testMapExample() {
    Map<String, Integer> intMap = new HashMap<>();
    assertTrue(intMap.isEmpty());
    assertTrue(intMap.size() == 0);

    intMap.put("Hello", 5);
    assertEquals(5, (int) intMap.get("Hello"));

    intMap.put("hi", 2);
    assertEquals(2, intMap.size());
    assertEquals(2, (int) intMap.get("hi"));

    Map<String, List<String>> stringMap = new HashMap<>();
    stringMap.put("hello", new ArrayList<>());
    stringMap.get("hello").add("H");
    assertEquals(List.of("H"), stringMap.get("hello"));

    for (Map.Entry<String, List<String>> entry : stringMap.entrySet()) {
      String key = entry.getKey();
      List<String> value = entry.getValue();
      // do whatever
    }
    for (String key : stringMap.keySet()) {
      List<String> value = stringMap.get(key);
    }
  }
}
