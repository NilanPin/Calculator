package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.EmptyStack;
import application.OpStack;
import application.Symbol;

class testOpStack {

  private OpStack os;
  
  @BeforeEach
  void setup() {
    os = new OpStack();
  }
  
  @Test
  // Test 30 - tests if the initial size of OpStack is 0
  // Constructor in OpStack created - initialises Stack
  void testSize() {
    assertEquals(os.getSize(), 0);
  }
  
  @Test
  // Test 31 - tests if float can pushed to the Stack
  // Push method implemented in OpStack (calls Stack.push)
  void testPushSymbol() {
    os.push(Symbol.TIME);
    assertEquals(os.getSize(), 1);
  }
  
  @Test
  // Test 32 - tests if a float can be popped from the Stack & checks if size decreases
  // Pop method implemented by calling Stack.pop and using getSymbol()
  // Uses toString() to get the symbol in a string format
  void testPopSymbol() throws EmptyStack, BadType {
    os.push(Symbol.PLUS);
    assertEquals(os.pop().toString(), "+");
    assertEquals(os.getSize(), 0);
  }

  @Test
  // Test 33
  void testTopSymbol() throws EmptyStack, BadType {
    os.push(Symbol.MINUS);
    assertEquals(os.top().toString(), "-");
    assertEquals(os.getSize(), 1);
  }
  
  @Test
  // Test 38
  void testPopEmpty() {
    assertThrows(EmptyStack.class, () -> os.pop(), "You can not pop from an empty stack");
  }


  @Test
  // Test 39
  void testTopEmpty() {
    assertThrows(EmptyStack.class, () -> os.top(), "Stack is empty!");
  }
  
}
