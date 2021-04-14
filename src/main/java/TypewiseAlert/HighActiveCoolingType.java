package TypewiseAlert;

public class HighActiveCoolingType implements ICoolingType
{

  @Override
  public double getUpperLimit()
  {
    return 45;
  }

  @Override
  public double getLowerLimit()
  {
    return 0;
  }

}
