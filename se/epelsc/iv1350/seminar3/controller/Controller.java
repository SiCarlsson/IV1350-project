package se.epelsc.iv1350.seminar3.controller;

import se.epelsc.iv1350.seminar3.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.integration.Printer;
import se.epelsc.iv1350.seminar3.model.Item;
//import se.epelsc.iv1350.seminar3.model.Payment;
import se.epelsc.iv1350.seminar3.model.Sale;

public class Controller {
  // Variables
  private Sale sale;
  // private Payment payment;

  // Constructor
  public Controller(Printer printer) {

  }

  /*
   * Resets variables to be ready to handle a new sale
   */
  public void startSale() {
    this.sale = new Sale();
    // this.payment = new Payment();
  }

  /*
   * Function to handle all loop logic to enter new items to sale
   */
  // private void saleLoop() {
  //
  // }

  /*
   * Function that adds an item specified by the cashier to the current sale
   * 
   * @params identifier An integer containing the item identifier
   */
  public void addItemToSale(int identifier) {
    sale.addItem(new Item(getItem(identifier)));
  }

  /*
   * 
   * 
   * @params
   */
  private ItemDTO getItem(int identifier) {
    // Collect ItemDTO from database here (not applicable during seminar3)
    return new ItemDTO(identifier, 0, 0, null, null);
  }
}
