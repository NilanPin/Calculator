package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testType {

  @Test
  // Test 11 - 1 attempt
  // toString() created to have printable Enum
  // Checks correct types are printed in string form
  void testtoString() {
    assertEquals(Type.STRING.toString(), "STRING");
    assertEquals(Type.NUMBER.toString(), "NUMBER");
    assertEquals(Type.SYMBOL.toString(), "SYMBOL");
    assertEquals(Type.INVALID.toString(), "INVALID");
    
    
  }

}
