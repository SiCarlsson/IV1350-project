package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class DiscountTotalPurchase implements DiscountStrategy {

  /**
   * Function handles a discount that targets the whole sale
   * 
   * @params the identifier of the discount
   * 
   * @return A double array consisting of the productID and the percentage
   *         discount on that product
   */
  @Override
  public DiscountDTO sendDiscountInformationToSale(int discountIdentifier) {
    return new DiscountDTO(discountIdentifier, 0.20);
  }
}
