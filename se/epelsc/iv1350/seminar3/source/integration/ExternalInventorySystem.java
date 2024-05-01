package se.epelsc.iv1350.seminar3.source.integration;

public class ExternalInventorySystem {
  /*
   * A function that updates the inventory system based on a sale
   * 
   * @params product ID, amount of that product
   */
  public void updateInventory(int productId, int amount) {
    
  }

  /*
   * Function collects ItemDTO from database here (not applicable during seminar3)
   * 
   * @params itemIdentifier The identifier of the product that should be fetched
   * from the database
   */
  public ItemDTO getItemDTOFromDatabase(int itemIdentifier) {
    if (Integer.toString(itemIdentifier).equals("123456")) {
      return new ItemDTO(itemIdentifier, 29.90, 0.06, "BigWheel Oatmeal",
          "BigWheel Oatmeal 500g, whole grain oats, high fiber , gluten free");
    }
    if (Integer.toString(itemIdentifier).equals("567890")) {
      return new ItemDTO(itemIdentifier, 14.90, 0.06, "YouGoGo Blueberry",
          "YouGoGo Blueberry 240g, low sugar youghurt, blueberry flavour");
    }
    return new ItemDTO(itemIdentifier, 10, 0.06, null, null);
  }

}