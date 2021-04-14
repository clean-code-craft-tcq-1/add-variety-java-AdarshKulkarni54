package TypewiseAlert;

public class MedActiveCoolingType implements ICoolingType
{

  @Override
  public double getUpperLimit()
  {
    return 40;
  }

  @Override
  public double getLowerLimit()
  {
    return 0;
  }

}
