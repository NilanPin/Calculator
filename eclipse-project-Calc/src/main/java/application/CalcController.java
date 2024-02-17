package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel = new CalcModel();
  private ViewInterface myView;
  private CalcView myCalcView = new CalcView();

  public CalcController(CalcModel model, ViewInterface view) {}

  public float evaluate(String string, boolean isinfix) throws InvalidExpression {
    return myModel.evaluate(string, isinfix);
  }
}

