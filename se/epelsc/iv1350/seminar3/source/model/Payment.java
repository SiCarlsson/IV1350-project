package se.epelsc.iv1350.seminar3.source.model;

public class Payment {
  private Register register;
  // Constructor
  public Payment(Register register) {
    this.register = register;
  }

  /*
   * Function makes a payment and puts left over cash in register
   */
  public void makePayment(double cashRecievedFromCustomer, double totalCost) {
    double newCashInRegister = cashRecievedFromCustomer - totalCost;
    this.register.updateRegister(newCashInRegister);
  }
}
