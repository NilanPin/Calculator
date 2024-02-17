package application;

/**
 * This class implements a Stack but only holds Symbol values.
 *
 * @author zlac347 
 */
public class OpStack {
  
  private Stack stack;
    
  public OpStack() {
    stack = new Stack();
  }
  
  public int getSize() {
    return stack.getSize();
  }

  public void push(Symbol symbol) {
    stack.push(new Entry(symbol));
  }

  public Symbol pop() throws BadType, EmptyStack {
    return stack.pop().getSymbol();
  }
  
  public Symbol top() throws BadType, EmptyStack {
    return stack.top().getSymbol();
  }

}
