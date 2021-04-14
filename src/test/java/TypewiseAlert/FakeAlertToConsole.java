package TypewiseAlert;

public class FakeAlertToConsole extends AlertToConsole
{
  int alertAndReportToConsoleCalledOnce = 0;
  String breachType = "";

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    super.alertAndReport(breachType);
    this.breachType = breachType.getBreachType();
    this.alertAndReportToConsoleCalledOnce++;
  }

  public int alertAndReportToConsoleCalledOnce()
  {
    return this.alertAndReportToConsoleCalledOnce;
  }

  public String getBreachType()
  {
    return this.breachType;
  }
}
