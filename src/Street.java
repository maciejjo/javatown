import java.util.Random;

public class Street extends RectangleField {

  public Street(double NewX1, double NewX2, double NewY1, double NewY2) {

    super(NewX1, NewX2, NewY1, NewY2);

  }

  @Override
  public Boolean CanAccess(Human Person) {

    Random rn = new Random();
    return rn.nextBoolean();

  }

}

