public class Policeman extends Human implements IWearingUniform, IPoliceOfficer {
  final private Uniform PoliceUniform;
  final private Badge PoliceBadge;

  public Policeman(String NewName) {
    super(NewName);
    PoliceUniform = new Uniform();
    PoliceBadge = new Badge();
  }

  @Override
  public Uniform ShowUniform() {
    return PoliceUniform;
  }

  @Override
  public Badge ShowBadge() {
    return PoliceBadge;
  }

}


