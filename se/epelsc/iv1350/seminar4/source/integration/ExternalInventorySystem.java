package se.epelsc.iv1350.seminar4.source.integration;

import se.epelsc.iv1350.seminar4.source.model.SaleDTO;

public class ExternalInventorySystem {
  /**
   * A function that goes through all items in the saleDTO and then updates the external inventory system
   * 
   */
  public void updateInventorySystem(SaleDTO saleDTO) {
    for (int i = 0; i < saleDTO.getItems().length; i++) {
      sendItemInformationToDatabase(saleDTO.getItems()[i].getItentifier(), saleDTO.getItems()[i].getAmount());
    }
  }

  /**
   * Function to send sale information to database
   * 
   * @param itemIdentifier
   * @param itemAmount
   */
  private void sendItemInformationToDatabase(int itemIdentifier, int itemAmount) {

  }

  /**
   * Function collects ItemDTO from database here (not applicable during seminar4)
   * 
   * @param itemIdentifier The identifier of the product that should be fetched
   *                       from the database
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