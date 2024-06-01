package se.epelsc.iv1350.higherGradeTasks.source.view;

import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;

public abstract class TotalRevenueTemplate {
  protected String FILE_NAME_ERROR_LOGS = "error_logs.txt";

  protected abstract void doShowTotalRevenue(double totalRevenue) throws Exception;

  protected abstract void handleErrors(Exception e);

  /**
   * Method handles the creation of a string with the total revenue
   * 
   * @param totalRevenue the current total revenue
   * @return a formatted string with the total revenue
   */
  protected String createStringWithTotalRevenue(double totalRevenue) {
    return "Total revenue: " + Calculations.roundTwoDecimalPoints(totalRevenue) + " SEK";
  }
}