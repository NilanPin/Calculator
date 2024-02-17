package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.BadType;
import application.EmptyStack;
import application.InvalidExpression;
import application.StandardCalc;

class testStandard {

  private StandardCalc sc;

  @BeforeEach
  void setUp() {
    sc = new StandardCalc();
  }

  @Test
  void test1() throws BadType, EmptyStack, InvalidExpression {
    assertEquals(1, sc.evaluate("1"));
  }

  @Test
  // I have implemented a simple shutting Yard algorithm in StandardCalc
  // Currently only works for expressions with only one operator
  void test2() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("3 2 +", sc.shuntingYard("3 + 2"));
  }

  @Test
  // This tests checks if the evaluate method returns the correct value
  // Calls shunttingYard stores answer to a String
  // Calls rpc.evaluate with the String returned in shutting yard.
  void test3() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("3 2 +", sc.shuntingYard("3 + 2"));
    assertEquals(5, sc.evaluate("3 + 2"));
  }

  // More tests to see if works on different expressions in the format x op y

  @Test
  void test4() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 4 +", sc.shuntingYard("12 + 4"));
    assertEquals(16, sc.evaluate("12 + 4"));
  }

  @Test
  void test5() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("41 9 -", sc.shuntingYard("41 - 9"));
    assertEquals(32, sc.evaluate("41 - 9"));
  }

  @Test
  void test6() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("14 21 -", sc.shuntingYard("14 - 21"));
    assertEquals(-7, sc.evaluate("14 - 21"));
  }

  @Test
  void test7() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("7 4 *", sc.shuntingYard("7 * 4"));
    assertEquals(28, sc.evaluate("7 * 4"));
  }

  @Test
  void test8() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("52 16 *", sc.shuntingYard("52 * 16"));
    assertEquals(832, sc.evaluate("52 * 16"));
  }

  @Test
  void test9() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("81 9 /", sc.shuntingYard("81 / 9"));
    assertEquals(9, sc.evaluate("81 / 9"));
  }

  @Test
  void test10() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("2 7 /", sc.shuntingYard("2 / 7"));
    assertEquals(0.2857143f, sc.evaluate("2 / 7"));
  }

  // Tests to see if it works in the format x op y op z & a op b op c op d
  
  @Test
  void test11() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("3 4 + 5 +", sc.shuntingYard("3 + 4 + 5"));
    assertEquals(12, sc.evaluate("3 + 4 + 5"));
  }

  @Test
  void test12() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("3 4 + 5 + 6 +", sc.shuntingYard("3 + 4 + 5 + 6"));
    assertEquals(18, sc.evaluate("3 + 4 + 5 + 6"));
  }

  @Test
  void test13() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("10 5 - 2 -", sc.shuntingYard("10 - 5 - 2"));
    assertEquals(3, sc.evaluate("10 - 5 - 2"));
  }
  
  @Test
  void test14() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("50 10 - 5 - 2 -", sc.shuntingYard("50 - 10 - 5 - 2"));
    assertEquals(33, sc.evaluate("50 - 10 - 5 - 2"));
  }
  
  @Test
  void test15() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 5 * 6 *", sc.shuntingYard("12 * 5 * 6"));
    assertEquals(360, sc.evaluate("12 * 5 * 6"));
  }
  
  @Test
  void test16() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("10 12 * 5 * 6 *", sc.shuntingYard("10 * 12 * 5 * 6"));
    assertEquals(3600, sc.evaluate("10 * 12 * 5 * 6"));
  }
  
  @Test
  void test17() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 4 / 3 /", sc.shuntingYard("12 / 4 / 3"));
    assertEquals(1, sc.evaluate("12 / 4 / 3"));
  }
  
  @Test
  void test18() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("144 12 / 4 / 3 /", sc.shuntingYard("144 / 12 / 4 / 3"));
    assertEquals(1, sc.evaluate("144 / 12 / 4 / 3"));
  }
  
//Tests to check that the stunting algorithm works on a single set of brackets
  
  @Test
  void test19Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("9 4 +",sc.shuntingYard("( 9 + 4 )"));
    assertEquals(13, sc.evaluate("( 9 + 4 )"));
  }
  
  @Test
  void test20Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("14 5 -",sc.shuntingYard("( 14 - 5 )"));
    assertEquals(9, sc.evaluate("( 14 - 5 )"));
  }
  @Test
  void test21Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("7 8 *",sc.shuntingYard("( 7 * 8 )"));
    assertEquals(56, sc.evaluate("( 7 * 8 )"));
  }
  
  @Test
  void test22Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("45 9 /",sc.shuntingYard("( 45 / 9 )"));
    assertEquals(5, sc.evaluate("( 45 / 9 )"));
  }
  
  @Test
  void test23Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("3 4 + 5 +", sc.shuntingYard("( 3 + 4 + 5 )"));
    assertEquals(12, sc.evaluate("( 3 + 4 + 5 )"));
  }
  
  @Test
  void test24Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 4 - 5 -", sc.shuntingYard("( 12 - 4 - 5 )"));
    assertEquals(3, sc.evaluate("( 12 - 4 - 5 )"));
  }
  
  @Test
  void test25Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("7 6 * 2 *", sc.shuntingYard("( 7 * 6 * 2 )"));
    assertEquals(84, sc.evaluate("( 7 * 6 * 2 )"));
  }
  
  @Test
  void test26Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("100 10 / 5 /", sc.shuntingYard("( 100 / 10 / 5 )"));
    assertEquals(2, sc.evaluate("( 100 / 10 / 5 )"));
  }
  
  @Test
  void test27Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("21 7 / 4 *", sc.shuntingYard("( 21 / 7  * 4 )"));
    assertEquals(12, sc.evaluate("( 21 / 7  * 4 )"));
  }
  
  @Test
  void test28Brackets() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 6 + 7 -", sc.shuntingYard("( 12 + 6 - 7 )"));
    assertEquals(11, sc.evaluate("( 12 + 6 - 7 )"));
  }
  
  // More tests to see if it works on expression with multiple ops
  
  @Test
  void test29MultiOp() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("5 4 * 6 +", sc.shuntingYard("5 * 4 + 6"));
    assertEquals(26, sc.evaluate("5 * 4 + 6"));
  }
  
  @Test
  void test30MultiOp() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("9 6 + 3 /", sc.shuntingYard("9 + 6 / 3"));
    assertEquals(5, sc.evaluate("9 + 6 / 3"));
  }
  
  @Test
  void test31MultiOp() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("14 6 * 5 -", sc.shuntingYard("14 * 6 - 5"));
    assertEquals(79, sc.evaluate("14 * 6 - 5"));
  }
  
  @Test
  void test32MultiOp() throws BadType, EmptyStack, InvalidExpression {
    assertEquals("12 6 * 3 /", sc.shuntingYard("12 * 6 / 3"));
    assertEquals(24, sc.evaluate("12 * 6 / 3"));
  }
  
}
