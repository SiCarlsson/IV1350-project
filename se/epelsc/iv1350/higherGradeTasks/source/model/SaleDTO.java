package se.epelsc.iv1350.higherGradeTasks.source.model;

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

  /**
   * Function handles logic regarding applyong a discount
   * 
   * @param discountInformation The information recieved from the discount
   *                            database
   */
  public void applyDiscountOnCurrentSale(double[] discountInformation) {
    if (discountInformation[0] == 0) {
      applyDiscountOnWholeSale(discountInformation[1]);
    } else {
      applyDiscountOnSpecificProduct(discountInformation[0], discountInformation[1]);
    }
    updateTotalCostOfSale();
  }

  /**
   * Function applies a percentage discount on all products
   * 
   * @param percentageDiscount the percentage all products should be reduced with
   */
  private void applyDiscountOnWholeSale(double percentageDiscount) {
    double currentPrice;
    double discountedPrice;
    for (int i = 0; i < this.items.length; i++) {
      currentPrice = this.items[i].getPrice();
      discountedPrice = 1 - percentageDiscount;
      this.items[i].setPrice(currentPrice * discountedPrice);
    }
  }

  /**
   * Function applies a percentage discount on a specific product
   * 
   * @param productIdentifier  the identifier of the product that should be
   *                           discounted
   * @param percentageDiscount the percentage the product should be reduced with
   */
  private void applyDiscountOnSpecificProduct(double productIdentifier, double percentageDiscount) {
    double currentPrice;
    double discountedPrice;
    for (int i = 0; i < this.items.length; i++) {
      if (this.items[i].getItentifier() == productIdentifier) {
        currentPrice = this.items[i].getPrice();
        discountedPrice = 1 - percentageDiscount;
        this.items[i].setPrice(currentPrice * discountedPrice);
      }
    }
  }

  /**
   * Functiuon updates the total cost of the sale
   */
  private void updateTotalCostOfSale() {
    double totalCostOfSale = 0;

    for (int i = 0; i < this.items.length; i++) {
      totalCostOfSale += this.items[i].getTotalItemPrice();
    }

    this.totalCostOfSale = totalCostOfSale;
  }
}
