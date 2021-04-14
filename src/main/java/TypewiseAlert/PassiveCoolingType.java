package TypewiseAlert;

public class PassiveCoolingType implements ICoolingType
{

  @Override
  public double getUpperLimit()
  {
    return 35;
  }

  @Override
  public double getLowerLimit()
  {
    return 0;
  }

}
