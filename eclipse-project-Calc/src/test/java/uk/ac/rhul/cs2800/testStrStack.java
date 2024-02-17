package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.EmptyStack;
import application.OpStack;
import application.StrStack;
import application.Symbol;

class testStrStack {

  private StrStack ss;
  
  @BeforeEach
  void setup() {
    ss = new StrStack();
  }
  
  @Test
  // Test 34 - tests if the initial size of StrStack is 0
  // Constructor in OpStack created - initialises Stack
  void testSize() {
    assertEquals(ss.getSize(), 0);
  }
  
  @Test
  // Test 35 - tests if Strings can pushed to the Stack
  // Push method implemented in StrStack (calls Stack.push)
  void testPushString() {
    ss.push("String in strStack");
    assertEquals(ss.getSize(), 1);
  }
  
  @Test
  // Test 36 - tests if a float can be popped from the Stack & checks if size decreases
  // Pop method implemented by calling Stack.pop and using getString()
  void testPopString() throws EmptyStack, BadType {
    ss.push("String in strStack");
    assertEquals(ss.pop(), "String in strStack");
    assertEquals(ss.getSize(), 0);
  }

  @Test
  // Test 37
  void testTopString() throws EmptyStack, BadType {
    ss.push("String in strStack");
    assertEquals(ss.top(), "String in strStack");
    assertEquals(ss.getSize(), 1);
  }
  
  @Test
  // Test 40
  void testPopEmpty() {
    assertThrows(EmptyStack.class, () -> ss.pop(), "You can not pop from an empty stack");
  }


  @Test
  // Test 41
  void testTopEmpty() {
    assertThrows(EmptyStack.class, () -> ss.top(), "Stack is empty!");
  }
  
}
