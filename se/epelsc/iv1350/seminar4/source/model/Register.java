package se.epelsc.iv1350.seminar4.source.model;

import java.util.ArrayList;
import java.util.List;

public class Register {
  private double moneyInRegister;
  private List<RegisterObserver> totalRevenueObservers = new ArrayList<>();

  private final double startingCashInRegister = 100;

  /**
   * Constructor
   */
  public Register() {
    this.moneyInRegister = startingCashInRegister;
  }

  /**
   * Updates the total amount of money in the register
   * 
   * @param netRecievedCash The amount of cash given by the customer when
   *                        purchasing subtracted by the change amount
   */
  public void updateRegister(double netRecievedCash) {
    this.moneyInRegister += netRecievedCash;
  }

  /**
   * Function returns the amount money in the register
   * 
   * @return The amount of money in the register
   */
  public double getMoneyInRegister() {
    return this.moneyInRegister;
  }

  public void addAllTotalRevenueOberservers(List<RegisterObserver> observers) {
    this.totalRevenueObservers.addAll(observers);
  }

  public void notifyTotalRevenueObservers() {
    for (RegisterObserver observer : totalRevenueObservers) {
      observer.updateTotalRevenue(this.moneyInRegister - this.startingCashInRegister);
    }
  }
}
