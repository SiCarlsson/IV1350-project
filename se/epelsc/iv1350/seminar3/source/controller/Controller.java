package se.epelsc.iv1350.seminar3.source.controller;

import se.epelsc.iv1350.seminar3.source.integration.ExternalAccountingSystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalDiscountDatabase;
import se.epelsc.iv1350.seminar3.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.seminar3.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Payment;
import se.epelsc.iv1350.seminar3.source.model.Register;
import se.epelsc.iv1350.seminar3.source.model.Sale;

public class Controller {
  private Sale sale;
  private Printer printer;
  private Register register;
  private Payment payment;
  private ExternalAccountingSystem exAccountingSys;
  private ExternalDiscountDatabase exDiscountDb;
  private ExternalInventorySystem exInventorySys;

  /*
   * Constructor
   * 
   * @param printer An instance of printer that should be used
   * 
   * @param exSysCreator An instance of externalSystemCreator, will in turn
   * establish connection with other external systems
   */
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
   * 
   * @return The instance of sale
   */
  public Sale getSale() {
    return this.sale;
  }

  /*
   * Function to get register
   * 
   * @return The instance of register
   */
  public Register getRegister() {
    return this.register;
  }

  /*
   * Function that adds an item specified by the cashier to the current sale
   * 
   * @param itemIdentifier An integer containing the item identifier that should
   * be added to the sale
   */
  public void addItemToSale(int itemIdentifier) {
    this.sale.addItem(new Item(this.exInventorySys.getItemDTOFromDatabase(itemIdentifier)));
    this.sale.outputSaleLog(itemIdentifier);
  }

  /*
   * Function handles logic to make a payment
   * 
   * @param cashReciefvedFromCustomer The amount of money recieved by the customer
   * to pay for the sale
   */
  private void handlePayment(double cashRecievedFromCustomer) {
    double totalCost = 0;

    for (int i = 0; i < this.sale.getTotalItems(); i++) {
      totalCost += this.sale.getItem(i).getTotalItemPrice();
    }

    this.payment.updateRegisterAmount(cashRecievedFromCustomer, totalCost);

    this.sale.getReceipt().setCashPaid(cashRecievedFromCustomer);
  }

  /*
   * Function prints the reciept as an output
   */
  private void printReceipt() {
    printer.print(this.sale.getReceipt());
  }

  /*
   * Function holds the logic when ending a sale
   * 
   * @param cashReciefvedFromCustomer The amount of money recieved by the customer
   * to pay for the sale
   */
  public void endSale(double cashRecievedFromCustomer) {
    handlePayment(cashRecievedFromCustomer);
    updateExternalSystems(cashRecievedFromCustomer, this.sale.getAllItemsFromCurrentSale());

    this.sale.endCurrentSale(cashRecievedFromCustomer);
    printReceipt();
  }

  /*
   * Function handles the logic of updating the external systems
   * 
   * @param cashReciefvedFromCustomer The amount of money recieved by the customer
   * to pay for the sale
   */
  private void updateExternalSystems(double cashRecievedFromCustomer, Item[] itemsInCurrentSale) {
    this.exAccountingSys.updateAccounting(cashRecievedFromCustomer);

    for (int i = 0; i < itemsInCurrentSale.length; i++) {
      this.exInventorySys.updateInventory(itemsInCurrentSale[i].getItentifier(), itemsInCurrentSale[i].getAmount());
    }
  }

  /*
   * Function returns the instance of external accounting system
   * 
   * @return An instance of ExternalAccountingSystem
   */
  public ExternalAccountingSystem getExternalAccountingSytem() {
    return this.exAccountingSys;
  }

  /*
   * Function returns the instance of external accounting system
   * 
   * @return An instance of ExternalDiscountSystem
   */
  public ExternalDiscountDatabase getExternalDiscountDatabase() {
    return this.exDiscountDb;
  }

  /*
   * Function returns the instance of external accounting system
   * 
   * @return An instance of ExternalInventorySystem
   */
  public ExternalInventorySystem getExternalInventorySystem() {
    return this.exInventorySys;
  }
}
