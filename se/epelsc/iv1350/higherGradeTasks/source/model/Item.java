package se.epelsc.iv1350.higherGradeTasks.source.model;

import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemDTO;

public class Item {
  private int identifier;
  private double price;
  private double VAT;
  private String name;
  private String description;
  private int amount;

  /**
   * Constructor function
   * 
   * @param itemDTO An instance of ItemDTO
   */
  public Item(ItemDTO itemDTO) {
    this.identifier = itemDTO.getItentifier();
    this.price = itemDTO.getPrice();
    this.VAT = itemDTO.getVAT();
    this.name = itemDTO.getName();
    this.description = itemDTO.getDescription();
    this.amount = itemDTO.getAmount();
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
   * Setter function to change the price of a product
   * 
   * @param newPrice the new price of the product
   */
  public void setPrice(double newPrice) {
    this.price = newPrice;
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
   * @return The item description
   */
  public int getAmount() {
    return this.amount;
  }

  /**
   * Function to increment the amount of an item by 1
   */
  public void incrementAmount() {
    this.amount++;
  }

  /**
   * Getter function to retrieve the total price of an item
   * 
   * @return the total cost of a product
   */
  public double getTotalItemPrice() {
    return this.amount * this.price;
  }
}
