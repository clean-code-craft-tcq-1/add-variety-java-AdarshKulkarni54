package TypewiseAlert;

public class HighBreachType implements IBreachType
{

  @Override
  public void alertAndReportByBreachType(final String recepient)
  {
    System.out.printf("To: %s\n", recepient);
    System.out.println("Hi, the temperature is too high\n");
  }

  @Override
  public String getBreachType()
  {
    return "High";
  }
}
