package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.CalcController;
import application.CalcModel;
import application.InvalidExpression;

class TestCalcController {

  @Test
  void testConstructor() {
    CalcController testController = new CalcController(null, null);
    assertNotNull(testController, "Default Controller construction test");
  }
  
  @Test
  void testEvaluate() throws InvalidExpression {
    CalcController testController = new CalcController(null, null);
    assertEquals(testController.evaluate("7", false), 7f);
  }
  
  @Test
  void testEvaluateMultiple() throws InvalidExpression {
    CalcController testController = new CalcController(null, null);
    assertEquals(testController.evaluate("5 7 -1 + + ", false), 5 + 7 + -1);
  }
  
}
