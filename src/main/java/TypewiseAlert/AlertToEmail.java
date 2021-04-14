package TypewiseAlert;

public class AlertToEmail implements IAlertTarget
{

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    String recepient = "a.b@c.com";
    breachType.alertAndReportByBreachType(recepient);
  }

}
