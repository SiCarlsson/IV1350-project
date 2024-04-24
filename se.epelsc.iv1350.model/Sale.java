package model;

// Importing LocalDateTime class from java.time package 
import java.time.LocalTime;

public class Sale {
  // Variables
  private LocalTime time;
  private Receipt receipt;

  /* 
   * Constructor
   */
  public Sale() {
    this.receipt = new Receipt();
  }

  /*
   * A function to get the current recipt of a sale
   * 
   * @return the reciept for the current sale
   */
  public Receipt getReceipt() {
    return receipt;
  }

  /*
   * A function to get the current time of a sale
   * 
   * @return the current time in java.time.LocalTime format
   */
  public LocalTime getTimeOfSale() {
    setTime();
    return time;
  }

  /*
   * A function to set the current time
   */
  private void setTime() {
    this.time = LocalTime.now();
  }

  /*
   * Send a request to the printer to print a receipt
   * 
   * @params All information that should be on the receipt
   */
  public void printReceipt(Receipt receipt) {

  }

  /*
   * Prepares to make a payment, no further inserts of products
   */
  public void makePayment() {

  }

  /*
   * Loop that allows the cashier to insert items
   * 
   * @params Reciept that will contain all items
   */
  private void insertItems(Receipt receipt) {
    while (true) {
      break;
    }
  }
}