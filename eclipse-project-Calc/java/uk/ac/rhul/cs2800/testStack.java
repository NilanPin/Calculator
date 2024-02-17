package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testStack {
  private Stack s;

  @BeforeEach
  // Before each test a new stack is created
  // In Stack an ArrayList an initialised to act as a stack
  void setup() {
    s = new Stack();
  }

  @Test
  // Test 1 - 1 attempt
  // getSize() created to return 0 initially - developed to return size variable
  // Checks the the initial size of the stack is 0
  void testSize() {
    assertEquals(s.getSize(), 0);
  }

  @Test
  // Test 2 - 3 attempt
  // push() and size variable created (set to 1 in push()) - developed to increment size
  // Further developed to add item to ArrayList
  // Updated to handle Entry - private fields created - constructors created
  // Pushes 10 on the stack checks if size increases to 1
  void testPush() {
    s.push(new Entry((float) 10));
    assertEquals(s.getSize(), 1);
  }

  @Test
  // Test 3 - 3 attempts
  // pop() created to return 10 - used size variable to return item at that index and remove item
  // Updated to handle Entry - getValue() created
  // Exception error - added throw clause to handle BadType from getValue() in Entry 
  // pushes 10 to the Stack and checks pop() returns 10, checks size decreased accordingly
  void testPop() throws EmptyStack, BadType {
    s.push(new Entry((float) 10));
    assertEquals(s.pop().getValue(), (float) 10);
    assertEquals(s.getSize(), 0);
  }


  @Test
  // Test 4 - 3 attempts
  // top() returned 10 - set size variable to return item at that index
  // Updated to handle Entry - use getValue()
  // Exception error - added throw clause to handle BadType from getValue() in Entry 
  // Pushes 10 checks top() returns 10 and size doesn't change
  void testTop() throws EmptyStack, BadType {
    s.push(new Entry((float) 10));
    assertEquals(s.top().getValue(), (float) 10, "Tests that pop returns 10.0f");
    assertEquals(s.getSize(), 1, "Tests that top does not decreases the size of a stack");
  }

  @Test
  // Test 5 - 1 attempt
  // pop should throw an exception if stack is empty
  void testPopEmpty() {
    assertThrows(EmptyStack.class, () -> s.pop(), "You can not pop from an empty stack");
  }


  @Test
  // Test 6 - 1 attempt
  // top should throw an exception if stack is empty
  void testTopEmpty() {
    assertThrows(EmptyStack.class, () -> s.top(), "Stack is empty!");
  }

  @Test
  // Test 7 - 3 attempts
  // 3 items pushed pop called 3 times - implemented once pop() was fully tested
  // getValue() from Entry implemented - exception - added throws clause
  // Tests to see if an exception is thrown after 3 push() and 3 pop()
  // Pushes 3 values on to the stack, call pop() to see correct return values
  void testMultiPush() throws EmptyStack, BadType {
    s.push(new Entry((float) 92));
    s.push(new Entry((float) 5));
    s.push(new Entry((float) 10));
    assertEquals(s.pop().getValue(), (float) 10, "Tests that pop returns 92.0f");
    assertEquals(s.pop().getValue(), (float) 5, "Tests that pop returns 5.0f");
    assertEquals(s.pop().getValue(), (float) 92, "Tests that pop returns 10.0f");
    testPopEmpty();
  }
  
  @Test
  // Test 15 checks if correct top() value is returned when two push()
  void testpushTwiceThenTop() throws EmptyStack, BadType {
    s.push(new Entry((float) 92));
    s.push(new Entry((float) 5));
    assertEquals(s.top().getValue(),(float)5);
  }
  
  @Test
  // Test 16 checks if a string can be Pushed and popped
  void testStringPushandPop() throws BadType, EmptyStack {
    s.push(new Entry ("Pushed"));
    assertEquals(s.getSize(), 1);
    assertEquals(s.pop().getString(),"Pushed");
  }
  
  @Test
  // Test 17 checks if a Symbol can be pushed and popped
  void testSymbolPushandPop() throws BadType, EmptyStack {
    s.push(new Entry(Symbol.MINUS));
    assertEquals(s.getSize(), 1);
    assertEquals(s.pop().getSymbol().toString(), "-");
  }
}
