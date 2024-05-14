package se.epelsc.iv1350.seminar4.source.model;

public class SaleDTO {
  private Item[] items;
  private Receipt receipt;
  private double totalCostOfSale;
  private double totalVATOfSale;

  public SaleDTO(Sale sale) {
    this.items = sale.getItemList();
    this.receipt = sale.getReceipt();
    this.totalCostOfSale = sale.getTotalSalePrice();
    this.totalVATOfSale = sale.getTotalVATOfSale();
  }

  /**
   * Getter function to reach item list
   * 
   * @return a list of all items
   */
  public Item[] getItems() {
    return this.items;
  }

  /**
   * Getter function to reach the receipt of a sale
   * 
   * @return the receipt of the sale
   */
  public Receipt getReceipt() {
    return this.receipt;
  }

  /**
   * Getter function to reach the total cost of a sale
   * 
   * @return the total cost of a sale
   */
  public double getTotalCostOfSale() {
    return this.totalCostOfSale;
  }

  /**
   * Getter function to reach the total VAT of a sale
   * 
   * @return the total VAT of a sale
   */
  public double getTotalVATOfSale() {
    return this.totalVATOfSale;
  }

  /**
   * Function gets the item of a sale based on the itemIdentifier
   * 
   * @param itemIdentifier Holds an identifier for an item
   * 
   * @return The item specified in a sale
   */
  public Item getItemByItemID(int itemIdentifier) {
    int i = 0;
    while (!(this.items[i].getItentifier() == itemIdentifier)) {
      i++;
    }
    return items[i];
  }
}
