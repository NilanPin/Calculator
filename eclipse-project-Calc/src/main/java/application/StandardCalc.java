package application;

import java.util.Scanner;


/**
 * Calculates the value of an infix expression.
 *
 * @author zlac347
 */
public class StandardCalc {

  private OpStack os;
  private RevPolishCalc rpc = new RevPolishCalc();

  /**
   * Calculates the result of infix expression converted to postfix.
   * 
   * @param expression the string to be evaluated
   * @return the answer to the infix calculation
   * @throws BadType if the wrong data type is evaluated
   * @throws EmptyStack if the stack is empty when pop/top is called
   * @throws InvalidExpression if there is a incorrect symbol
   */
  public float evaluate(String expression) throws BadType, EmptyStack, InvalidExpression {
    String newExpression = shuntingYard(expression);
    return rpc.evaluate(newExpression);

  }

  /**
   * Converts a infix expression to postfix.
   * 
   * @param string the infix expression
   * @return the postfix expression
   * @throws BadType if a wrong data type is given
   * @throws EmptyStack if the stack is empty when pop/top is called
   * @throws InvalidExpression if there is a incorrect symbol
   */
  public String shuntingYard(String string) throws BadType, EmptyStack, InvalidExpression {
    String postfix = "";
    os = new OpStack();
    Scanner scanner = new Scanner(string);
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        String number = String.valueOf(scanner.nextInt());
        postfix = postfix + number + " ";
        if (os.getSize() != 0) {
          if (os.top().equals(Symbol.INVALID)) {
            throw new InvalidExpression();
          }
          String op = os.pop().toString();
          postfix = postfix + op + " ";
        }
      } else {
        pushOps(scanner.next());
      }
    }
    scanner.close();
    // Removes the gap at the end of the String
    return postfix.substring(0, postfix.length() - 1);
  }

  /**
   * This method pushes the symbols to an OpStack.
   * 
   * @param expression the string representation for the Symbols to be pushed.
   */
  public void pushOps(String expression) {
    if (expression.equals(Symbol.PLUS.toString())) {
      os.push(Symbol.PLUS);
    } else if (expression.equals(Symbol.MINUS.toString())) {
      os.push(Symbol.MINUS);
    } else if (expression.equals(Symbol.TIME.toString())) {
      os.push(Symbol.TIME);
    } else if (expression.equals(Symbol.DIVIDE.toString())) {
      os.push(Symbol.DIVIDE);
    } else if (!(expression.equals("(")) && !(expression.equals(")"))) {
      os.push(Symbol.INVALID);
    }
  }

}

