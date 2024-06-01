package se.epelsc.iv1350.higherGradeTasks.source.integration;

public class ItemDTO {
  private int identifier;
  private double price;
  private double VAT;
  private String name;
  private String description;
  private int amount;

  /**
   * Constructor function
   * 
   * @param identifier The item ID retrieved from the database
   * 
   * @param price The item price
   * 
   * @param VAT The VAT in percentage for an item
   * 
   * @param name The name of an item
   * 
   * @param description A short clarification of each item
   */
  public ItemDTO(int identifier, double price, double VAT, String name, String description) {
    this.identifier = identifier;
    this.price = price;
    this.VAT = VAT;
    this.name = name;
    this.description = description;

    int numberOfProcuctsInTheBeginning = 1;
    this.amount = numberOfProcuctsInTheBeginning;
  }

  /**
   * Getter function to retrieve ItemDTO itendifier
   * 
   * @return The item identifier
   */
  public int getItentifier() {
    return this.identifier;
  }

  /**
   * Getter function to retrieve ItemDTO price
   * 
   * @return The item price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Getter function to retrieve ItemDTO VAT
   * 
   * @return The item VAT
   */
  public double getVAT() {
    return this.VAT;
  }

  /**
   * Getter function to retrieve ItemDTO name
   * 
   * @return The item name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter function to retrieve ItemDTO description
   * 
   * @return The item description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Getter function to retrieve ItemDTO amount
   * 
   * @return The item amount
   */
  public int getAmount() {
    return this.amount;
  }
}
