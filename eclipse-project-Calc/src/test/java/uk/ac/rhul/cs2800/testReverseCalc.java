package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.EmptyStack;
import application.InvalidExpression;
import application.RevPolishCalc;

class testReverseCalc {
  
  private RevPolishCalc rpc;
  
  @BeforeEach
  void setup() {
    rpc = new RevPolishCalc();
  }
  
  
  @Test
  // Create evaluate method in RevPolishCalc - faked return 1f
  public void testadd() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(1, rpc.evaluate("1"));
  }
  
  @Test
  // Added a while loop in evaluate to loop through a STRING
  // Added if statement to check for ints and push to stack as Entry
  // Pop values in stack and add them together then push to stack
  public void test2add() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(6, rpc.evaluate("1 5 +"));
  }
  
  // The next two tests checks if it still correctly calculates the expression with more than 2 numbers
  
  @Test
  public void test3add() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(8, rpc.evaluate("1 5 2 + +"));
  }
  
  @Test
  public void test4add() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(17, rpc.evaluate("1 5 2 9 + + +"));
  }
  
  @Test
  // Added if statement to check if there's a Plus in the string if not subtraction happens
  public void test5substract() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(-5, rpc.evaluate("4 9 -"));
  }
  
  @Test
  // Checks if negative values are returned
  public void test6substract() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(5, rpc.evaluate("9 4 -"));
  }
  
//The next two tests checks if it still correctly calculates the expression with more than 2 numbers
  
  @Test
  public void test7substract() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(8, rpc.evaluate("3 4 9 - -"));
  }
  
  @Test
  public void test8substract() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(-8, rpc.evaluate("3 4 2 9 - - -"));
  }
  
  @Test
  // else if added to check for * to multiply the numbers
  public void test9multiply() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(8, rpc.evaluate("2 4 *"));
  }
  
//The next two tests checks if it still correctly calculates the expression with more than 2 numbers
  
  @Test
  public void test10multiply() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(72, rpc.evaluate("2 4 9 * *"));
  }
  @Test
  public void test11multiply() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(216, rpc.evaluate("9 4 2 3 * * *"));
  }
  
  @Test
  // final else if added to check if numbers can be correctly divided
  public void test12divide() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(0.5f, rpc.evaluate("3 6 /"));
  }
  
  @Test
  // checks if decimals can be correctly calculated
  public void test13divide() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(2f, rpc.evaluate("6 3 /"));
  }
  
//The next two tests checks if it still correctly calculates the expression with more than 2 numbers
  
  @Test
  public void test14divide() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(1f, rpc.evaluate("2 6 3 / /"));
  }
  
  @Test
  public void test15divide() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(0.0625f, rpc.evaluate("2 4 8 64 / / /"));
  }
  
  // The next tests are now checking to see if the RPC works for expressions with multiple symbols
  
  @Test
  // Added a method called pushOps
  // Updated evaluate to perform the correct calculation based on the state of OpStack
  public void test16multiOP() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(14.0f, rpc.evaluate("2 3 4 + *"));
  }
  
  @Test
  public void test17multiOP() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(0.7f, rpc.evaluate("7 8 2 + /"));
  }
  
  @Test
  public void test18multiOP() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(91f, rpc.evaluate("4 9 + 7 *"));
  }
  
  @Test
  public void test19ultiOP() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(4.5f, rpc.evaluate("4 9 6 2 + /  * "));
  }
  
  @Test
  public void test20multiOP() throws EmptyStack, BadType, InvalidExpression {
    assertEquals(25f, rpc.evaluate("5 2 3 + *"));
  }
  
  @Test
  public void test21catch() {
    assertThrows(InvalidExpression.class, () -> rpc.evaluate("9 7 ?"));
  }
  
}
