package se.epelsc.iv1350.seminar3.source.view;

import se.epelsc.iv1350.seminar3.source.controller.Controller;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.SaleDTO;
import se.epelsc.iv1350.seminar3.source.util.Calculations;

public class View {
  private Controller contr;

  /**
   * Constructor
   * 
   * @param An instance of controller
   */
  public View(Controller contr) {
    this.contr = contr;
  }

  /**
   * Function handles the logic when the cashier initializes a sale
   */
  public void cashierStartsSale() {
    contr.startSale();
  }

  /**
   * Function handles the logic when the cashier enters an item
   * 
   * @param itemIdentifier The identifier of the item that should be added to the
   *                       sale
   */
  public void cashierAddsItem(int itemIdentifier) {
    contr.addItemToSale(itemIdentifier);
    outputSaleLog(itemIdentifier);
  }

  /**
   * Function handles the logic when the cashier ends a sale
   * 
   * @param cashRecievedFromCustomer The amount of money handed by the customer to
   *                                 pay for the sale
   */
  public void cashierEndSale(double cashRecievedFromCustomer) {
    contr.endSale(cashRecievedFromCustomer);
    outputLogsEndSale(cashRecievedFromCustomer);
  }

  /**
   * Function that handles the loging of a sale
   * 
   * @param itemIdentifier Holds an identifier for an item
   */
  private void outputSaleLog(int itemIdentifier) {
    SaleDTO saleDTO = contr.getSaleDTO();
    Item lastItem = saleDTO.getItemByItemID(itemIdentifier);

    System.out.println("Add 1 item with id " + lastItem.getItentifier() + ":");
    System.out.println("Item ID: " + lastItem.getItentifier());
    System.out.println("Item name: " + lastItem.getName());
    System.out.println("Item cost: " + lastItem.getPrice() + " " +
        saleDTO.getReceipt().getCurrency());
    System.out.println("VAT: " + (lastItem.getVAT() * 100) + "%");
    System.out.println("Item description: " + lastItem.getDescription());
    System.out.println();
    System.out.println("Total cost (incl VAT): " + saleDTO.getTotalCostOfSale() + " " +
        saleDTO.getReceipt().getCurrency());
    System.out.println(
        "Total VAT: " + Calculations.roundTwoDecimalPoints(saleDTO.getTotalVATOfSale())
            + " " + saleDTO.getReceipt().getCurrency());
    System.out.println();
  }

  /**
   * Function handles all logging regarding the end of a current sale
   * 
   * @param cashRecievedFromCustomer The amount of money handed by the customer
   */
  private void outputLogsEndSale(double cashRecievedFromCustomer) {
    SaleDTO saleDTO = contr.getSaleDTO();

    String currency = saleDTO.getReceipt().getCurrency();

    System.out.println("End sale:");
    System.out.println("Total cost (incl VAT): " + saleDTO.getTotalCostOfSale() + " " +
        currency);
    System.out.println();

    System.out.println("Customer pays " + cashRecievedFromCustomer + " " +
        currency + ":");
    System.out.println("Sent sale info to external accounting system.");

    for (int i = 0; i < saleDTO.getItems().length; i++) {
      int itemIdentifier = saleDTO.getItems()[i].getItentifier();
      int itemAmount = saleDTO.getItems()[i].getAmount();

      System.out.println("Told external inventory system to decrease inventory quantity of item " + itemIdentifier
          + " by " + itemAmount + " units.");
    }
    System.out.println();
  }
}