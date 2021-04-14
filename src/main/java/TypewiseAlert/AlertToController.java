package TypewiseAlert;

public class AlertToController implements IAlertTarget
{

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    int header = 0xfeed;
    System.out.printf("%d : %s", header, breachType.getBreachType());
  }

}
