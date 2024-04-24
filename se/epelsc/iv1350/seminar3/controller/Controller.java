package se.epelsc.iv1350.seminar3.controller;

import se.epelsc.iv1350.seminar3.integration.Printer;
import se.epelsc.iv1350.seminar3.model.Payment;
import se.epelsc.iv1350.seminar3.model.Sale;

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

  /*
   * Function to handle all loop logic to enter new items to sale
   */
  private void saleLoop() {

  }

  /*
   * Loop that allows the cashier to insert items
   * 
   * @params Reciept that will contain all items
   */
  private void addItemToSale(Sale sale) {
    while (true) {
      break;
    }
  }
}
