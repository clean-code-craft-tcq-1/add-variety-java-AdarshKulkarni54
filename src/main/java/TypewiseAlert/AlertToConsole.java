package TypewiseAlert;

public class AlertToConsole implements IAlertTarget
{

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    System.out.println("Hi, alerting from console");
  }
}
