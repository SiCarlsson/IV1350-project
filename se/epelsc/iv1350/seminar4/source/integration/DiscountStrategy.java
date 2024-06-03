package se.epelsc.iv1350.seminar4.source.integration;

public interface DiscountStrategy {
  DiscountDTO sendDiscountInformationToSale(int discountIdentifier);
}
