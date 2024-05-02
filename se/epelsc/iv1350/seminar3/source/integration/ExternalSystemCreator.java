package se.epelsc.iv1350.seminar3.source.integration;

public class ExternalSystemCreator {
  private ExternalAccountingSystem externalAccountingSystem;
  private ExternalDiscountDatabase externalDiscountDatabase;
  private ExternalInventorySystem externalInventorySystem;

  /**
   * Constructor
   */
  public ExternalSystemCreator() {
    externalAccountingSystem = new ExternalAccountingSystem();
    externalDiscountDatabase = new ExternalDiscountDatabase();
    externalInventorySystem = new ExternalInventorySystem();
  }

  /**
   * A function that gets an instancce of ExternalAccountingSystem.java
   * 
   * @return An instance of the class ExternalAccountingSystem
   */
  public ExternalAccountingSystem getAccountingSystem() {
    return externalAccountingSystem;
  }

  /**
   * A function that gets an instancce of ExternalDiscountDatabase.java
   * 
   * @return An instance of the class ExternalAccountingSystem
   */
  public ExternalDiscountDatabase getDiscountDatabase() {
    return externalDiscountDatabase;
  }

  /**
   * A function that gets an instancce of ExternalInventorySystem.java
   * 
   * @return An instance of the class ExternalInventorySystem
   */
  public ExternalInventorySystem getInventorySystem() {
    return externalInventorySystem;
  }
}