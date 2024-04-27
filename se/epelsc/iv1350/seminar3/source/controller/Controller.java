package se.epelsc.iv1350.seminar3.source.controller;

import se.epelsc.iv1350.seminar3.source.integration.ExternalAccountingSystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalDiscountDatabase;
import se.epelsc.iv1350.seminar3.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Sale;

public class Controller {
  // Variables
  private Sale sale;
  private Printer printer;
  private ExternalAccountingSystem exAccountingSys;
  private ExternalDiscountDatabase exDiscountDb;
  private ExternalInventorySystem exInventorySys;

  // Constructor
  public Controller(Printer printer, ExternalSystemCreator exSysCreator) {
    this.printer = printer;
    this.exAccountingSys = exSysCreator.getAccountingSystem();
    this.exDiscountDb = exSysCreator.getDiscountDatabase();
    this.exInventorySys = exSysCreator.getInventorySystem();
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
   * @params itemIdentifier An integer containing the item identifier that should
   * be added to the sale
   */
  public void addItemToSale(int itemIdentifier) {
    sale.addItem(new Item(this.exInventorySys.getItemDTOFromDatabase(itemIdentifier)));
  }

  /*
   * Function prints the reciept as an output
   */
  public void printReceipt() {
    printer.print(this.sale.getReceipt());
  }

  /*
   * Function returns the instance of external accounting system
   */
  public ExternalAccountingSystem getExternalAccountingSytem() {
    return this.exAccountingSys;
  }

  /*
   * Function returns the instance of external accounting system
   */
  public ExternalDiscountDatabase getExternalDiscountDatabase() {
    return this.exDiscountDb;
  }

  /*
   * Function returns the instance of external accounting system
   */
  public ExternalInventorySystem getExternalInventorySystem() {
    return this.exInventorySys;
  }
}
