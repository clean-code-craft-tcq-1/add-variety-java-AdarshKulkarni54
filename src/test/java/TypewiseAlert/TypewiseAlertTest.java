package TypewiseAlert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TypewiseAlertTest
{
  @Test
  public void infersBreachAsPerLimits()
  {
    assertEquals(new LowBreachType().getBreachType(), TypewiseAlert.inferBreach(12, 20, 30).getBreachType());
    assertEquals(new HighBreachType().getBreachType(), TypewiseAlert.inferBreach(35, 20, 30).getBreachType());
    assertEquals(new NormalBreachType().getBreachType(), TypewiseAlert.inferBreach(35, 05, 35).getBreachType());
  }

  @Test
  public void testClassifyTemperatureBreachForPassiveCoolingType()
  {
    assertEquals(new NormalBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new PassiveCoolingType(), 12).getBreachType());
    assertEquals(new LowBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new PassiveCoolingType(), -1).getBreachType());
    assertEquals(new HighBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new PassiveCoolingType(), 36).getBreachType());
  }

  @Test
  public void testClassifyTemperatureBreachForHighActiveCoolingType()
  {
    assertEquals(new NormalBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new HighActiveCoolingType(), 35).getBreachType());
    assertEquals(new LowBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new HighActiveCoolingType(), -1).getBreachType());
    assertEquals(new HighBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new HighActiveCoolingType(), 46).getBreachType());
  }

  @Test
  public void testClassifyTemperatureBreachAsForMedActiveCoolingType()
  {
    assertEquals(new NormalBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new MedActiveCoolingType(), 40).getBreachType());
    assertEquals(new LowBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new MedActiveCoolingType(), -1).getBreachType());
    assertEquals(new HighBreachType().getBreachType(), TypewiseAlert.classifyTemperatureBreach(new MedActiveCoolingType(), 41).getBreachType());
  }

  @Test
  public void testCheckAndAlertToConsoleForNormalBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new PassiveCoolingType());
    FakeAlertToConsole alertTarget = new FakeAlertToConsole();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 12);
    assertEquals(1, alertTarget.alertAndReportToConsoleCalledOnce());
    assertEquals("Normal", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToConsoleForLowBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new HighActiveCoolingType());
    FakeAlertToConsole alertTarget = new FakeAlertToConsole();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1);
    assertEquals(1, alertTarget.alertAndReportToConsoleCalledOnce());
    assertEquals("Low", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToConsoleForHighBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new MedActiveCoolingType());
    FakeAlertToConsole alertTarget = new FakeAlertToConsole();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 41);
    assertEquals(1, alertTarget.alertAndReportToConsoleCalledOnce());
    assertEquals("High", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToControllerForNormalBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new PassiveCoolingType());
    FakeAlertToController alertTarget = new FakeAlertToController();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 12);
    assertEquals(1, alertTarget.alertAndReportToControllerCalledOnce());
    assertEquals("Normal", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToControllerForLowBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new HighActiveCoolingType());
    FakeAlertToController alertTarget = new FakeAlertToController();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1);
    assertEquals(1, alertTarget.alertAndReportToControllerCalledOnce());
    assertEquals("Low", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToControllerForHighBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new MedActiveCoolingType());
    FakeAlertToController alertTarget = new FakeAlertToController();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 41);
    assertEquals(1, alertTarget.alertAndReportToControllerCalledOnce());
    assertEquals("High", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToEmailForNormalBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new PassiveCoolingType());
    FakeAlertToEmail alertTarget = new FakeAlertToEmail();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 20);
    assertEquals(1, alertTarget.alertAndReportToEmailCalledOnce());
    assertEquals("Normal", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToEmailForLowBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new HighActiveCoolingType());
    FakeAlertToEmail alertTarget = new FakeAlertToEmail();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1);
    assertEquals(1, alertTarget.alertAndReportToEmailCalledOnce());
    assertEquals("Low", alertTarget.getBreachType());
  }

  @Test
  public void testCheckAndAlertToEmailForHighBreachType()
  {
    BatteryCharacter batteryCharacter = new BatteryCharacter();
    batteryCharacter.setCoolingType(new MedActiveCoolingType());
    FakeAlertToEmail alertTarget = new FakeAlertToEmail();
    TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 41);
    assertEquals(1, alertTarget.alertAndReportToEmailCalledOnce());
    assertEquals("High", alertTarget.getBreachType());
  }
}
