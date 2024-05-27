package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class DiscountTotalPurchase implements DiscountStrategy {

  /**
   * Function handles a discount that targets the whole sale
   * 
   * @return A double array consisting of the productID and the percentage
   *         discount on that product
   */
  @Override
  public double[] sendDiscountInformationToSale() {
    return new double[]{0, 0.20};
  }
}
