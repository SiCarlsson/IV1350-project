package se.epelsc.iv1350.seminar4.source.view;

import se.epelsc.iv1350.seminar4.source.util.Calculations;
import se.epelsc.iv1350.seminar4.source.util.Textfiles;
import se.epelsc.iv1350.seminar4.source.model.RegisterObserver;

public class TotalRevenueFileOutput implements RegisterObserver {

  private static final String FILE_NAME = "total_revenue.txt";

  /**
   * Constructor
   * 
   * @throws IOException if file cannot be created
   */
  public TotalRevenueFileOutput() {
    Textfiles.createTextFile(FILE_NAME);
  }

  /**
   * Writes accumulated revenue to the textfile
   */
  @Override
  public void updateTotalRevenue(double totalRevenue) {
    String content = "Total revenue: " + Calculations.roundTwoDecimalPoints(totalRevenue) + " SEK";
    Textfiles.writeToTextFile(FILE_NAME, content);
  }

}
