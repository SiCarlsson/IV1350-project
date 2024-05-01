package se.epelsc.iv1350.seminar3.source.model;

public class Register {
  private double moneyInRegister;

  /*
   * Constructor
   */
  public Register() {
    this.moneyInRegister = 100;
  }

  /*
   * Updates the total amount of money in the register
   * 
   * @param netRecievedCash The amount of cash given by the customer when
   * purchasing subtracted by the change amount
   */
  public void updateRegister(double netRecievedCash) {
    this.moneyInRegister += netRecievedCash;
  }

  /*
   * Function returns the amount money in the register
   * 
   * @return The amount of money in the register
   */
  public double getMoneyInRegister() {
    return this.moneyInRegister;
  }
}
