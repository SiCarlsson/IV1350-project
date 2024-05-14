package se.epelsc.iv1350.seminar4.source.util;

import java.text.DecimalFormat;

public class Calculations {
  /**
   * Function rounds a double value to two decimal points
   * 
   * @param valueToRound The value that should be rounded to two decimal points
   * 
   * @return The rounded value in String format
   */
  public static String roundTwoDecimalPoints(double valueToRound) {
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(valueToRound);
  }
}
