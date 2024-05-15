package se.epelsc.iv1350.seminar4.source.model;

public interface RegisterObserver {

  /**
   * Function to observe a new sale
   * 
   * @param totalRevenue Total price of the sale including VAT
   */
  public void updateTotalRevenue(double totalRevenue);
}
