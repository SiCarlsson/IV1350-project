package se.epelsc.iv1350.seminar4.source.integration;

public class DiscountSpecificProduct implements DiscountStrategy {

  /**
   * Function handles a discount that targets a specific product
   * 
   * @return A double array consisting of the productID and the percentage discount on that product
   */
  @Override
  public DiscountDTO sendDiscountInformationToSale(int discountIdentifier) {
    return new DiscountDTO(discountIdentifier, 0.20);
  }
}
