package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class DiscountSpecificProduct implements DiscountStrategy {

  /**
   * Function handles a discount that targets a specific product
   * 
   * @return A double array consisting of the productID and the percentage discount on that product
   */
  @Override
  public double[] sendDiscountInformationToSale() {
    return new double[]{123456, 0.20};
  }
}
