package se.epelsc.iv1350.seminar4.source.model;

public class Payment {
  private Register register;
  /**
   * Constructor
   * 
   * @param register An instance of register
   */
  public Payment(Register register) {
    this.register = register;
  }

  /**
   * Function makes a payment and puts left over cash in register
   * 
   * @param cashRecievedFromCustomer The amount of money handed by the customer to pay for the current sale
   * @param totalCost The total cost of the current sale
   */
  public void updateRegisterAmount(double cashRecievedFromCustomer, double totalCost) {
    double newCashInRegister = cashRecievedFromCustomer - totalCost;
    this.register.updateRegister(newCashInRegister);
  }

  /**
   * Function gets the register of a payment
   * 
   * @return The instance of register
   */
  public Register getRegister() {
    return this.register;
  }
}
