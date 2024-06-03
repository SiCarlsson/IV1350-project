package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class ExternalDiscountDatabase {
  DiscountSpecificProduct discountSpecificProduct;
  DiscountTotalPurchase discountTotalPurchase;

  /**
   * Constructor
   */
  public ExternalDiscountDatabase() {
    this.discountSpecificProduct = new DiscountSpecificProduct();
    this.discountTotalPurchase = new DiscountTotalPurchase();
  }

  /**
   * A function that collects a discount code from the discount database
   * 
   * @param discountID The discount mentioned by the customer
   * 
   * @return An ID for the fetched deiscount code
   */
  public DiscountDTO fetchDiscount(int discountID) {
    if (discountID == 123456) {
      return this.discountSpecificProduct.sendDiscountInformationToSale(discountID);
    } else if (discountID == 567890) {
      return this.discountTotalPurchase.sendDiscountInformationToSale(discountID);
    }
    return new DiscountDTO(0, 0);
  }
}
