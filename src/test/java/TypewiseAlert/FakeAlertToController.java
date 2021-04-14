package TypewiseAlert;

public class FakeAlertToController extends AlertToController
{
  int alertAndReportToControllerCalledOnce = 0;
  String breachType = "";

  @Override
  public void alertAndReport(final IBreachType breachType)
  {
    super.alertAndReport(breachType);
    this.breachType = breachType.getBreachType();
    this.alertAndReportToControllerCalledOnce++;
  }

  public int alertAndReportToControllerCalledOnce()
  {
    return this.alertAndReportToControllerCalledOnce;
  }

  public String getBreachType()
  {
    return this.breachType;
  }
}
