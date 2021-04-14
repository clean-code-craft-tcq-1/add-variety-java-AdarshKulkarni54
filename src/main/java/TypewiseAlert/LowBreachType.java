package TypewiseAlert;

public class LowBreachType implements IBreachType
{

  @Override
  public void alertAndReportByBreachType(final String recepient)
  {
    System.out.printf("To: %s\n", recepient);
    System.out.println("Hi, the temperature is too low\n");
  }

  @Override
  public String getBreachType()
  {
    return "Low";
  }

}
