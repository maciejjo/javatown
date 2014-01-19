public class Builder extends Human implements IWearingUniform, ILicensedBuilder {
  final private Uniform BuilderUniform;
  final private Permission BuilderPermission;

  public Builder(String NewName) {
    super(NewName);
    BuilderUniform = new Uniform();
    BuilderPermission = new Permission();
  }

  @Override
  public Permission ShowPermission() {
    return BuilderPermission;
  }

  @Override
  public Uniform ShowUniform() {
    return BuilderUniform;
  }

}

