package se.epelsc.iv1350.seminar3.model;

import se.epelsc.iv1350.seminar3.integration.ItemDTO;

public class Item {
  // Variables
  private int identifier;
  private double price;
  private double VAT;
  private String name;
  private String description;

  public Item(ItemDTO itemDTO) {
    this.identifier = itemDTO.getItentifier();
    this.price = itemDTO.getPrice();
    this.VAT = itemDTO.getVAT();
    this.name = itemDTO.getName();
    this.description = itemDTO.getDescription();
  }

  /*
   * Getter function to retrieve ItemDTO itendifier
   * 
   * @return The item identifier
   */
  public int getItentifier() {
    return this.identifier;
  }

  /*
   * Getter function to retrieve ItemDTO price
   * 
   * @return The item price
   */
  public double getPrice() {
    return this.price;
  }

  /*
   * Getter function to retrieve ItemDTO VAT
   * 
   * @return The item VAT
   */
  public double getVAT() {
    return this.VAT;
  }

  /*
   * Getter function to retrieve ItemDTO name
   * 
   * @return The item name
   */
  public String getName() {
    return this.name;
  }

  /*
   * Getter function to retrieve ItemDTO description
   * 
   * @return The item description
   */
  public String getDescription() {
    return this.description;
  }
}
