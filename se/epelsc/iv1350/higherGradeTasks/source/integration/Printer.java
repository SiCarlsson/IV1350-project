package se.epelsc.iv1350.higherGradeTasks.source.integration;

import se.epelsc.iv1350.seminar4.source.model.Receipt;

public class Printer {
  /**
   * Function to handle the print of a reciept
   * 
   * @param receipt An instance of the reciept that should be printed
   */
  public void print(Receipt receipt) {
    receipt.createReceipt();
  }
}
