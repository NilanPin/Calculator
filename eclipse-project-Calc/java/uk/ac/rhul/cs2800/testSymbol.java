package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testSymbol {

  @Test
  // Test 12 - 1 attempt
  // toString() created to have printable Enum
  // checks if the correct symbol string is returned
  void testtoString() {
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.INVALID.toString(),"INVALID");
  }

}
