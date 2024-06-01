package se.epelsc.iv1350.higherGradeTasks.source.view;

import se.epelsc.iv1350.higherGradeTasks.source.util.Textfiles;

import java.io.IOException;

import se.epelsc.iv1350.higherGradeTasks.source.model.RegisterObserver;

public class TotalRevenueFileOutput extends TotalRevenueTemplate implements RegisterObserver {
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
    showTotalRevenue(totalRevenue);
  }

  /**
   * Functions holds the logic regarding showing the total revenue
   * 
   * @param totalRevenue the total revenue of all sales so far
   */
  private void showTotalRevenue(double totalRevenue) {
    try {
      doShowTotalRevenue(totalRevenue);
    } catch (Exception e) {
      handleErrors(e);
    }
  }

  /**
   * Method stores the total revenue to file
   * 
   * @param the total revenue of all sales so far
   * 
   * @throws error while logging to the file
   */
  @Override
  protected void doShowTotalRevenue(double totalRevenue) throws Exception {
    Textfiles.writeToTextFile(FILE_NAME, createStringWithTotalRevenue(totalRevenue));
  }

  /**
   * Method handles errors while logging the total revenue
   * 
   * @param e the exception that needs to be handled
   */
  @Override
  protected void handleErrors(Exception e) {
    Textfiles.writeToTextFile(FILE_NAME_ERROR_LOGS,
        "An error occured while logging total revenue to " + FILE_NAME_ERROR_LOGS + " " + e.getStackTrace() + "\n");
  }

}
