package application;

import java.util.Scanner;

/**
 * This is the class that will work out postfix expressions. 
 *
 * @author zlac347
 */
public class RevPolishCalc {

  private NumStack stack;
  private OpStack os;
  /**
   * Calculates the answer to a posfix expression. Expressions should be separated by whitespace
   *
   * @param string the postfix expression to be calculated
   * @return the calculated answer
   * @throws EmptyStack if the stack is empty
   * @throws BadType if the wrong primitive is given
   * @throws InvalidExpression if there is a incorrect symbol 
   */

  public float evaluate(String string) throws EmptyStack, BadType, InvalidExpression {
    stack = new NumStack();
    os = new OpStack();
    Scanner scanner = new Scanner(string);
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        stack.push(scanner.nextInt());
      } else {
        pushOps(scanner.next());
        float arg2 = stack.pop();
        float arg1 = stack.pop();
        String op = os.pop().toString();
        if (op.equals("+")) {
          stack.push(arg1 + arg2);
        } else if (op.equals("-")) {
          stack.push(arg1 - arg2);
        } else if (op.equals("*")) {
          stack.push(arg1 * arg2);
        } else if (op.equals("/") && arg2 != 0) {
          stack.push(arg1 / arg2);
        } else {
          throw new InvalidExpression();
        }
      }
    }
    scanner.close();
    return stack.pop();
  }


  /**
   * This method pushes the symbols to an OpStack so the correct operation can be
   * performed in the evaluate method.
   *
   * @param expression  the string representation for the Symbols to be pushed.
   */
  private void pushOps(String expression) {
    if (expression.equals(Symbol.PLUS.toString())) {
      os.push(Symbol.PLUS);
    } else if (expression.equals(Symbol.MINUS.toString())) {
      os.push(Symbol.MINUS);
    } else if (expression.equals(Symbol.TIME.toString())) {
      os.push(Symbol.TIME);
    } else if (expression.equals(Symbol.DIVIDE.toString())) {
      os.push(Symbol.DIVIDE);
    } else {
      os.push(Symbol.INVALID);
    }
  }
}

