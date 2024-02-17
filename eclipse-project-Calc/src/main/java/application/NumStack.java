package application;

import java.util.ArrayList;

/**
 * This class implements a Stack but only holds float values.
 *
 * @author zlac347 
 */
public class NumStack {

  private Stack stack;

  public NumStack() {
    stack = new Stack();
  }

  public int getSize() {
    return stack.getSize();
  }

  public void push(float f) {
    stack.push(new Entry(f));
  }

  public float pop() throws EmptyStack, BadType {
    return stack.pop().getValue();
  }

  public float top() throws BadType, EmptyStack {
    return stack.top().getValue();
  }

}

