package se.epelsc.iv1350.seminar3.source.controller;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Sale;

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
   * Function to get the current sale
   */
  public Sale getSale() {
    return this.sale;
  }

  /*
   * Function that adds an item specified by the cashier to the current sale
   * 
   * @params itemIdentifier An integer containing the item identifier that should be added to the sale
   */
  public void addItemToSale(int itemIdentifier) {
    sale.addItem(new Item(getItemDTOFromDatabase(itemIdentifier)));
  }

  /*
   * Function collect ItemDTO from database here (not applicable during seminar3)
   * Here it only returns expected return values
   * 
   * @params itemIdentifier The identifier of the product that should be fetched from the database
   */
  private ItemDTO getItemDTOFromDatabase(int itemIdentifier) {
    return new ItemDTO(itemIdentifier, 0, 0, null, null);
  }
}
