package se.epelsc.iv1350.seminar4.source.view;

import se.epelsc.iv1350.seminar4.source.model.RegisterObserver;
import se.epelsc.iv1350.seminar4.source.util.Calculations;

class TotalRevenueView implements RegisterObserver {
  @Override
  public void updateTotalRevenue(double totalRevenue) {
    System.out.println("Total revenue: " + Calculations.roundTwoDecimalPoints(totalRevenue) + "\n");
  }
}