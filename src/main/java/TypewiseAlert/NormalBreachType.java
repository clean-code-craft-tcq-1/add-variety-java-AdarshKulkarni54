package TypewiseAlert;

public class NormalBreachType implements IBreachType
{

  @Override
  public void alertAndReportByBreachType(final String recepient)
  {
    // for normal temperature, need not to alert to user
  }

  @Override
  public String getBreachType()
  {
    return "Normal";
  }

}
