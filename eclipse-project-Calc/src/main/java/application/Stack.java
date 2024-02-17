package application;

import java.util.ArrayList;
import java.util.EmptyStackException;


/**
 * This class creates a Stack.
 *
 * @author zlac347
 * 
 */
public class Stack {

  /**
   * The stack of type Entry given default size of 0.
   */
  private final ArrayList<Entry> list = new ArrayList<Entry>();
  private int size = 0;

  /**
   * get size of stack.
   *
   * @return the size of the stack
   */
  public int getSize() {
    return this.size;
  }


  /**
   * Adds item to stack increments size.  
   *
   * @param item to add to stack
   */
  public void push(Entry item) {
    this.list.add(item);
    this.size++;
  }

  /**
   * Removes the last item added to the Stack.
   *
   * @return entry item at the top
   * @throws EmptyStackException if stack is empty
   */
  public Entry pop() throws EmptyStack {
    if (size == 0) {
      throw new EmptyStack();
    } else {
      this.size--;
      Entry entry = (Entry) this.list.remove(this.size);
      return entry;
    }
  }



  /**
   * Returns last item added to the Stack.
   *
   * @return entry item at the top
   * @throws EmptyStackException if stack is empty
   */
  public Entry top() throws EmptyStack {
    if (size == 0) {
      throw new EmptyStack();
    } else {
      Entry entry = (Entry) this.list.get(this.size - 1);
      return entry;
    }
  }
}

