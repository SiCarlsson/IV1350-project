package se.epelsc.iv1350.seminar4.source.view;

import java.io.IOException;

import se.epelsc.iv1350.seminar3.source.util.Calculations;
import se.epelsc.iv1350.seminar4.source.model.RegisterObserver;
import se.epelsc.iv1350.seminar4.source.util.Textfiles;

public class TotalRevenueFileOutput implements RegisterObserver {

  private static final String FILE_NAME = "total_revenue.txt";

  /**
   * Constructor
   * 
   * @throws IOException if file cannot be created
   */
  public TotalRevenueFileOutput() throws IOException {
    Textfiles.createTextFile(FILE_NAME);
  }

  
  /**
   * Writes accumulated revenue to the textfile
   */
  @Override
  public void updateTotalRevenue(double totalRevenue) {
    String content = "Total revenue: " + Calculations.roundTwoDecimalPoints(totalRevenue);
    Textfiles.writeToTextFile(FILE_NAME, content);
  }

}
