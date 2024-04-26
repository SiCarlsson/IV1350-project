package se.epelsc.iv1350.seminar3.source.integration;

public class ExternalInventorySystem {
  // Variables

  // Constructor
  public ExternalInventorySystem() {

  }

  /*
   * A function that updates the inventory system based on a sale
   * 
   * @params product ID, amount of that product
   */
  public void updateInventory(int productId, int amount) {
    // insert code here
  }

  /*
   * Function collects ItemDTO from database here (not applicable during seminar3)
   * 
   * @params itemIdentifier The identifier of the product that should be fetched from the database
   */
  public ItemDTO getItemDTOFromDatabase(int itemIdentifier) {
    return new ItemDTO(itemIdentifier, 0, 0, null, null);
  }
}