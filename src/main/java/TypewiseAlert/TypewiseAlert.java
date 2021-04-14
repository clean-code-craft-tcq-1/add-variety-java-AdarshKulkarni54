package TypewiseAlert;

public class TypewiseAlert
{

  private TypewiseAlert()
  {
    //
  }

  public static IBreachType inferBreach(final double value, final double lowerLimit, final double upperLimit)
  {
    if (value < lowerLimit)
    {
      return new LowBreachType();
    }
    if (value > upperLimit)
    {
      return new HighBreachType();
    }
    return new NormalBreachType();
  }

  public static IBreachType classifyTemperatureBreach(final ICoolingType coolingType, final double temperatureInC)
  {
    return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
  }

  public static void checkAndAlert(final IAlertTarget alertTarget, final BatteryCharacter batteryChar, final double temperatureInC)
  {
    IBreachType breachType = classifyTemperatureBreach(batteryChar.getCoolingType(), temperatureInC);
    alertTarget.alertAndReport(breachType);
  }
}
