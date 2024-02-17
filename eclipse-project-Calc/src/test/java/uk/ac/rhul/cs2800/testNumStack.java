package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.EmptyStack;
import application.NumStack;
import application.Stack;

class testNumStack {

  private NumStack s;

  @BeforeEach
  void setup() {
    s = new NumStack();
  }

  @Test
  // Test 24 - tests if the initial size of NumStack is 0
  // Constructor in NumStack created - initialises Stack
  void testSize() {
    assertEquals(s.getSize(), 0);
  }

  @Test
  // Test 25 - tests if float can pushed to the Stack
  // Push method implemented in NumStack (calls Stack.push)
  void testPushFloat() {
    s.push(10.0f);
    assertEquals(s.getSize(), 1);
  }

  @Test
  // Test 26 - tests if a float can be popped from the Stack & checks if size decreases
  // Pop method implemented by calling Stack.pop and using getValue() to get a float value
  void testPopFloat() throws EmptyStack, BadType {
    s.push(9.0f);
    assertEquals(s.pop(), 9.0f);
    assertEquals(s.getSize(), 0);
  }

  @Test
  // Test 27
  void testTopFloat() throws EmptyStack, BadType {
    s.push(9.0f);
    assertEquals(s.top(), 9.0f);
    assertEquals(s.getSize(), 1);
  }
  
  // Test 28 & 29 are the same as the ones in testStack
  
  @Test
  // Test 28
  void testPopEmpty() {
    assertThrows(EmptyStack.class, () -> s.pop(), "You can not pop from an empty stack");
  }


  @Test
  // Test 29
  void testTopEmpty() {
    assertThrows(EmptyStack.class, () -> s.top(), "Stack is empty!");
  }
  
}

