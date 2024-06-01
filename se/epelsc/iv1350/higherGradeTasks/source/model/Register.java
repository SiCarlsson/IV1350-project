package se.epelsc.iv1350.higherGradeTasks.source.model;

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
    notifyTotalRevenueObservers();
  }

  /**
   * Function returns the amount money in the register
   * 
   * @return The amount of money in the register
   */
  public double getMoneyInRegister() {
    return this.moneyInRegister;
  }

  /**
   * Method gets the total revenue of all sales
   * 
   * @return the total revenue
   */
  private double getTotalRevenue() {
    return getMoneyInRegister() - this.startingCashInRegister;
  }

  /**
   * Method adds new observers to RevenueObservers
   * 
   * @param observers an ArrayList of observers to add
   */
  public void addTotalRevenueObserver(RegisterObserver observers) {
    this.totalRevenueObservers.add(observers);
  }

  /**
   * Function notifies all revenue observers
   */
  private void notifyTotalRevenueObservers() {
    for (RegisterObserver observer : this.totalRevenueObservers) {
      observer.updateTotalRevenue(getTotalRevenue());
    }
  }
}
