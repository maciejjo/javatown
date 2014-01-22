public class ConstructionSite extends RectangleField {

  public ConstructionSite(double NewX1, double NewX2, double NewY1, double NewY2) {

    super(NewX1, NewX2, NewY1, NewY2);

  }

  @Override
  public Boolean CanAccess(Human Person) {

    if(Person.ShowUniform() instanceof Uniform)
      return true;
    return false;

  }

}

