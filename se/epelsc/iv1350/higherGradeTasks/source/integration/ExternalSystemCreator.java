package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class ExternalSystemCreator {
  private static ExternalSystemCreator instanceOfExternalSystemCreator;
  private ExternalAccountingSystem externalAccountingSystem;
  private ExternalDiscountDatabase externalDiscountDatabase;
  private ExternalInventorySystem externalInventorySystem;

  /**
   * Constructor
   */
  private ExternalSystemCreator() {
    externalAccountingSystem = new ExternalAccountingSystem();
    externalDiscountDatabase = new ExternalDiscountDatabase();
    externalInventorySystem = new ExternalInventorySystem();
  }

  /**
   * Method to get the instance of ExternalSystemCreator (Singleton pattern)
   * 
   * @return the instance of ExternalSystemCreator used in the program
   */
  public static ExternalSystemCreator getInstanceOfExternalSystemCreator() {
    if (instanceOfExternalSystemCreator == null) {
      instanceOfExternalSystemCreator = new ExternalSystemCreator();
    }
    return instanceOfExternalSystemCreator;
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