package se.epelsc.iv1350.higherGradeTasks.source.integration;

public interface DiscountStrategy {
  DiscountDTO sendDiscountInformationToSale(int discountIdentifier);
}
