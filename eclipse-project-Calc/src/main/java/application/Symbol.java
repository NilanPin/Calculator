package application;

/**
 * Enum class of symbol.
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIME("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "INVALID");

  private String string;

  /**
   * Constructor method for Enums. 
   *
   * @param symbolString assigned to string to be used in toString().
   */
  private Symbol(String symbolString) {
    this.string = symbolString;
  }
  
  /**
   * Allows for a printable Enum - outputs symbol as a String.
   *
   * @return string of symbol
   */
  public String toString() {
    return this.string;
  }
}

