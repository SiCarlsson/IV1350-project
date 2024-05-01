package se.epelsc.iv1350.seminar3.source.view;

import se.epelsc.iv1350.seminar3.source.controller.Controller;

public class View {
  private Controller contr;

  /*
   * Constructor
   * 
   * @param An instance of controller
   */
  public View(Controller contr) {
    this.contr = contr;
  }

  /*
   * Function handles the logic when the cashier initializes a sale
   */
  public void cashierStartsSale() {
    contr.startSale();
  }

  /*
   * Function handles the logic when the cashier enters an item
   * 
   * @param itemIdentifier The identifier of the item that should be added to the sale
   */
  public void cashierAddsItem(int itemIdentifier) {
    contr.addItemToSale(itemIdentifier);
  }

  /*
   * Function handles the logic when the cashier ends a sale
   * 
   * @param cashRecievedFromCustomer The amount of money handed by the customer to pay for the sale
   */
  public void cashierEndSale(double cashRecievedFromCustomer) {
    contr.endSale(cashRecievedFromCustomer);
  }
}