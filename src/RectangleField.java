abstract public class RectangleField {

  public double X1, X2, Y1, Y2;
  abstract public Boolean CanAccess(Human Person);

  public RectangleField(double NewX1, double NewX2, double NewY1, double NewY2) {
    
    X1 = NewX1;
    X2 = NewX2;
    Y1 = NewY1;
    Y2 = NewY2;

  }

}
