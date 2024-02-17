package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import application.CalcModel;

class testCalcModel {

  private CalcModel cm;
  
  @BeforeEach
  void setUp() {
    cm = new CalcModel();
  }

  @Test
  void test() {
    assertEquals(10, cm.evaluate("5 + 5", true));
  }
  
  @Test
  void test2() {
    assertEquals(10, cm.evaluate("5 5 +", false));
  }
  @Test
  void test3() {
    assertEquals(Float.MIN_VALUE, cm.evaluate("9 ? 8", false));
  }
  
  @Test
  void test4() {
    assertEquals(Float.MIN_VALUE, cm.evaluate("9 ? 8", true));
  }
  
}
