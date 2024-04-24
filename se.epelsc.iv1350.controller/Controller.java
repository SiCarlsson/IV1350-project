package controller;

import integration.Printer;
import model.Receipt;
import model.Sale;

public class Controller {
  // Variables
  private Sale sale;
  private Payment payment;

  // Constructor
  public Controller(Printer printer) {

  }

  /*
   * Resets variables to be ready to handle a new sale
   */
  public void startSale() {
    this.sale = new Sale();
    this.payment = new Payment();
  }
}
