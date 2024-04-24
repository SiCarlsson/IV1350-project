package se.epelsc.iv1350.seminar3.source.integration;

public class ExternalSystemCreator {
  // Constructor
  public ExternalSystemCreator() {
    // insert code here
  }

  /*
   * A function that gets an instancce of ExternalAccountingSystem.java
   * 
   * @return An instance of the class ExternalAccountingSystem
   */
  public ExternalAccountingSystem getAccountingSystem() {
    return new ExternalAccountingSystem();
  }

  /*
   * A function that gets an instancce of ExternalDiscountDatabase.java
   * 
   * @return An instance of the class ExternalAccountingSystem
   */
  public ExternalDiscountDatabase getDiscountDatabase() {
    return new ExternalDiscountDatabase();
  }

  /*
   * A function that gets an instancce of ExternalInventorySystem.java
   * 
   * @return An instance of the class ExternalInventorySystem
   */
  public ExternalInventorySystem getInventorySystem() {
    return new ExternalInventorySystem();
  }
}