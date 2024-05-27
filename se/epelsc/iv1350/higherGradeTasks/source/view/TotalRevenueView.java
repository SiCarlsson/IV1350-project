package se.epelsc.iv1350.higherGradeTasks.source.view;

import se.epelsc.iv1350.higherGradeTasks.source.model.RegisterObserver;
import se.epelsc.iv1350.higherGradeTasks.source.util.Textfiles;

public class TotalRevenueView extends TotalRevenueTemplate implements RegisterObserver {
  @Override
  public void updateTotalRevenue(double totalRevenue) {
    showTotalRevenue(totalRevenue);
  }

  private void showTotalRevenue(double totalRevenue) {
    try {
      doShowTotalRevenue(totalRevenue);
    } catch (Exception e) {
      handleErrors(e);
    }
  }

  /**
   * Function holds the logic of displaying the total revenue
   * 
   * @throws Exception
   */
  @Override
  protected void doShowTotalRevenue(double totalRevenue) throws Exception {
    System.out.println(createStringWithTotalRevenue(totalRevenue) + "\n");
  }

  /**
   * Method handles errors when trying to display the total revenue
   * 
   * @param e the error that needs to be handled
   */
  @Override
  protected void handleErrors(Exception e) {
    Textfiles.writeToTextFile(FILE_NAME_ERROR_LOGS,
        "An error occured while displaying total revenue\n" + e.getStackTrace() + "\n");
  }
}