package application;

/**
 * This class implements a Stack but only holds String values.
 *
 * @author zlac347 
 */
public class StrStack {

  private Stack stack;

  public StrStack() {
    stack = new Stack();
  }

  public int getSize() {
    return stack.getSize();
  }

  public void push(String s) {
    stack.push(new Entry(s));
  }

  public String pop() throws EmptyStack, BadType {
    return stack.pop().getString();
  }

  public String top() throws BadType, EmptyStack {
    return stack.top().getString();
  }

}
