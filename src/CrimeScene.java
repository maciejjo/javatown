public class CrimeScene extends RectangleField {

  public CrimeScene(double NewX1, double NewX2, double NewY1, double NewY2) {

    super(NewX1, NewX2, NewY1, NewY2);

  }

  @Override
  public Boolean CanAccess(Human Person) {

    if(Person.ShowBadge() instanceof Badge)
      return true;
    return false;

  }

}

