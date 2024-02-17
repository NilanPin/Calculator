package application;

/**
 * Enum class of types.
 */
public enum Type {
  STRING("STRING"), NUMBER("NUMBER"), SYMBOL("SYMBOL"), INVALID("INVALID");
  
  private String string;

  /**
   * Constructor for Type.
   *
   * @param s assigned to String - used in toString().
   */
  private Type(String s) {
    this.string = s;
  }
  
  /**
   * Allows for a printable ENUM.
   *
   * @return string of Type
   */
  public String toString() {
    return this.string;
  }
}


