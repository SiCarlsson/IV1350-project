package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class DiscountDTO {
  private int dicsountIntentifier;
  private double percentageDiscount;

  /**
   * Constructor
   * 
   * @param discountIdentifier the identifier of the disocunt
   * @param percentageDiscount the percentage of discount that should be used
   */
  public DiscountDTO(int discountIdentifier, double percentageDiscount) {
    this.dicsountIntentifier = discountIdentifier;
    this.percentageDiscount = percentageDiscount;
  }

  /**
   * Method to get the disocunt identifier
   * 
   * @return the identifieer for the discount DTO
   */
  public int getDiscountIdentifier() {
    return this.dicsountIntentifier;
  }

  /**
   * Method to get the discount percentage
   * 
   * @return the discount percentage of the DTO
   */
  public double getDiscountPercentage() {
    return this.percentageDiscount;
  }
}
