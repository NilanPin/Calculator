package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {

  private RevPolishCalc rpc = new RevPolishCalc();
  private StandardCalc sc = new StandardCalc();

  @Override
  public float evaluate(String expression, Boolean infix) {
    if (infix) {
      try {
        return sc.evaluate(expression);
      } catch (BadType | EmptyStack | InvalidExpression e) {
        e.printStackTrace();
        return Float.MIN_VALUE;
      }
    } else {
      try {
        return rpc.evaluate(expression);
      } catch (InvalidExpression | EmptyStack | BadType e) {
        e.printStackTrace();
        return Float.MIN_VALUE;
      }
    }

  }
}

