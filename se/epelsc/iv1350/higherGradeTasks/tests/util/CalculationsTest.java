package se.epelsc.iv1350.higherGradeTasks.tests.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;

public class CalculationsTest {
  @Test
  public void testRoundTwoDecimalPoints() {
    String firstExpectedOutut = "5,87";
    double firstValueToBeRounded = 5.874664;
    
    String secondExpectedOutut = "13,37";
    double secondValueToBeRounded = 13.3712357;
    
    String thirdExpectedOutut = "9,13";
    double thirdValueToBeRounded = 9.129765;

    assertEquals(firstExpectedOutut, Calculations.roundTwoDecimalPoints(firstValueToBeRounded),
        "Rounding did not work as intended");
    assertEquals(secondExpectedOutut, Calculations.roundTwoDecimalPoints(secondValueToBeRounded),
        "Rounding did not work as intended");
    assertEquals(thirdExpectedOutut, Calculations.roundTwoDecimalPoints(thirdValueToBeRounded),
        "Rounding did not work as intended");
  }
}
