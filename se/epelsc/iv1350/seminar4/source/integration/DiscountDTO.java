package se.epelsc.iv1350.seminar4.source.integration;

public class DiscountDTO {
  private int dicsountIntentifier;
  private double percentageDiscount;

  public DiscountDTO(int discountIdentifier, double percentageDiscount) {
    this.dicsountIntentifier = discountIdentifier;
    this.percentageDiscount = percentageDiscount;
  }

  public int getDiscountIdentifier() {
    return this.dicsountIntentifier;
  }

  public double getDiscountPercentage() {
    return this.percentageDiscount;
  }
}
