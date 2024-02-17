package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.Entry;
import application.Symbol;
import application.Type;

class testEntry {

  @Test
  // Test 8 - 3 attempts
  // getValue() created returns 15
  // Updated to return number
  // Exception error when called with a String - BadType class created (exception thrown)
  // checks that the correct value of type number is returned
  void testgetValue() throws BadType {
    Entry e = new Entry((float) 15);
    assertEquals(e.getValue(), (float) 15);
    Entry x = new Entry("string");
    assertThrows(BadType.class, () -> x.getValue(), "Type is not NUMBER!");
  }

  @Test
  // Test 9 - 3 attempts
  // getString() created returns "String test"
  // Updated to return str
  // Exception error when called with a int - throws BadType added
  // checks that the correct string of type String is returned
  void testgetString() throws BadType {
    Entry e = new Entry("String test");
    assertEquals(e.getString(), "String test");
    Entry x = new Entry((float) 15);
    assertThrows(BadType.class, () -> x.getString(), "Type is not STRING!");
  }

  @Test
  // Test 10 - 3 attempts
  // Enum type created 
  // Once Type tests passed getType() created to return type
  // Symbol Enum and tests created to test Type Symbol
  // Checks that types are correctly identified
  void testgetType() {
    Entry e = new Entry((float) 15);
    assertEquals(e.getType(), Type.NUMBER);
    Entry x = new Entry(Symbol.PLUS);
    assertEquals(x.getType(), Type.SYMBOL);
    Entry y = new Entry("Test");
    assertEquals(y.getType(), Type.STRING);
  }

  @Test
  // Test 13 - 4 attempts
  // Auto generate equals() created in Entry
  // Two equal Entry created to test if true is returned
  // Auto generate hashcode() in Entry
  // Two objects with the same hashcode should be equal
  // Third entry object created to see if equals and hashcode correctly returns false with prev object
  // Checks if two objects are equal and that two objects aren't
  void testFloatEquals() {
    Entry e = new Entry((float) 20);
    Entry x = new Entry((float) 20);
    Entry y = new Entry((float) 17);
    assertEquals(e.equals(x), true);
    assertEquals(e.equals(y), false);
  }

  @Test
  // Test 14 - 4 attempts
  // Developed in the same format as Test 13
  void testStringEquals() {
    Entry e = new Entry("This is a String");
    Entry x = new Entry("This is a String");
    Entry y = new Entry("This is a different String");
    assertEquals(e.equals(x), true);
    assertEquals(e.equals(y), false);
  }
  
  @Test
  void testGetSymbol() throws BadType {
    Entry e = new Entry(Symbol.PLUS);
    assertEquals(e.getSymbol().toString(),"+");
    Entry x = new Entry((float) 15);
    assertThrows(BadType.class, () -> x.getSymbol(), "Type is not SYMBOL!");
  }
  
  /*
   * I have made the test hash code as its own separate unit test
   */
  @Test
  // Test 22 - cut and paste hash code parts form test 14
  void testStringHashCode() {
    Entry e = new Entry("This is a String");
    Entry x = new Entry("This is a String");
    Entry y = new Entry("This is a different String");
    assertEquals(e.hashCode(), x.hashCode());
    assertNotEquals(e.hashCode(), y.hashCode());
  }
  @Test
  // Test 23 - cut and paste hash code parts from test 13
  void testFloatHashCode() {
    Entry e = new Entry((float) 20);
    Entry x = new Entry((float) 20);
    Entry y = new Entry((float) 17);
    assertEquals(e.hashCode(), x.hashCode());
    assertNotEquals(e.hashCode(), y.hashCode());

  }
}

