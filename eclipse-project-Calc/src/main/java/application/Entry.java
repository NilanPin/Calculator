package application;

import java.util.Objects;

/**
 * Entry class allowing items to be added to a stack.
 *
 * @author zlac347
 * 
 *
 */
public class Entry {
  private float number = 0.0f;
  private Symbol other = null;
  private String str = null;
  private Type type;

  /**
   * Constructor method for floats.
   *
   * @param value given type NUMBER
   */
  public Entry(float value) {
    this.type = Type.NUMBER;
    this.number = value;
  }

  /**
   * Constructor for Symbols.
   *
   * @param s given type SYMBOL
   */
  public Entry(Symbol s) {
    this.type = Type.SYMBOL;
    this.other = s;
  }

  /**
   * Constructor for String.
   *
   * @param string given type STRING
   */
  public Entry(String string) {
    this.type = Type.STRING;
    this.str = string;
  }

  /**
   * Gets the type (String,float,symbol).
   *
   * @return type
   */
  public Type getType() {
    return this.type;
  }

  /**
   * gets the value of a float.
   *
   * @return number
   * @throws BadType if type isn't a number
   */
  public float getValue() throws BadType {
    if (this.type == type.NUMBER) {
      return this.number;
    } else {
      throw new BadType();
    }
  }

  /**
   * gets the String.
   *
   * @return str
   * @throws BadType if type isn't a String
   */
  public String getString() throws BadType {
    if (this.type.equals(type.STRING)) {
      return this.str;
    } else {
      throw new BadType();
    }
  }

  /**
   * getter method for symbols. 
   *
   * @return Symbol
   * @throws BadType if type isn't a symbol
   */
  public Symbol getSymbol() throws BadType {
    if (this.type.equals(type.SYMBOL)) {
      return this.other;
    } else {
      throw new BadType();
    }
  }

  /**
   * Hashes an object (auto-generated method).
   *
   * @return Object.hash
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  /**
   * Checks if two objects are equal (auto-generated method).
   *
   * @return true/false if objects are equal/not equal
   */
  @Override
  public boolean equals(Object obj) {
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
  }

}

