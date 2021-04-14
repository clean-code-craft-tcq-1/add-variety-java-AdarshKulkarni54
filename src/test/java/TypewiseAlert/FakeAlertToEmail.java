package TypewiseAlert;

public class FakeAlertToEmail extends AlertToEmail
{
  int alertAndReportToEmailCalledOnce = 0;
  String breachType = "";

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    super.alertAndReport(breachType);
    this.breachType = breachType.getBreachType();
    this.alertAndReportToEmailCalledOnce++;
  }

  public int alertAndReportToEmailCalledOnce()
  {
    return this.alertAndReportToEmailCalledOnce;
  }

  public String getBreachType()
  {
    return this.breachType;
  }
}
