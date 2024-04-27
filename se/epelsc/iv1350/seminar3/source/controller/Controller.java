package se.epelsc.iv1350.seminar3.source.controller;

import se.epelsc.iv1350.seminar3.source.integration.ExternalAccountingSystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalDiscountDatabase;
import se.epelsc.iv1350.seminar3.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Payment;
import se.epelsc.iv1350.seminar3.source.model.Receipt;
import se.epelsc.iv1350.seminar3.source.model.Register;
import se.epelsc.iv1350.seminar3.source.model.Sale;

public class Controller {
  // Variables
  private Sale sale;
  private Printer printer;
  private Register register;
  private Payment payment;
  private ExternalAccountingSystem exAccountingSys;
  private ExternalDiscountDatabase exDiscountDb;
  private ExternalInventorySystem exInventorySys;

  // Constructor
  public Controller(Printer printer, ExternalSystemCreator exSysCreator) {
    this.printer = printer;
    this.exAccountingSys = exSysCreator.getAccountingSystem();
    this.exDiscountDb = exSysCreator.getDiscountDatabase();
    this.exInventorySys = exSysCreator.getInventorySystem();
    this.register = new Register();
    this.payment = new Payment(register);
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
   * Function to get register
   */
  public Register getRegister() {
    return this.register;
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
   * Function handles logic to make a payment
   */
  public void handlePayment(double cashRecievedFromCustomer) {
    double totalCost = Double.parseDouble(this.sale.getReceipt().outputTotalCostOfSale());
    this.payment.makePayment(cashRecievedFromCustomer, totalCost);
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
