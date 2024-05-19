package se.epelsc.iv1350.seminar4.source.integration;

import java.sql.SQLException;
import java.util.InputMismatchException;

import se.epelsc.iv1350.seminar4.source.model.SaleDTO;

public class ExternalInventorySystem {
  private boolean connectionToDatabase;
  private String FILE_NAME_ERROR_LOGS;

  public ExternalInventorySystem() {
    this.connectionToDatabase = true;
    this.FILE_NAME_ERROR_LOGS = "error_logs.txt";
  }

  /**
   * Getter function to retrieve the variable connectionToDatabase
   * @return
   */
  public boolean getConnectionToDatabase() {
    return this.connectionToDatabase;
  }

  /**
   * Setter function to change the value of connectionToDatabase
   * @param condition the new state of the connectionToDatabse
   */
  public void setConnectionToDatabase(boolean condition) {
    this.connectionToDatabase = condition;
  }

  /**
   * A function that goes through all items in the saleDTO and then updates the
   * 
   * external inventory system
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
   * @throws ItemCatalogUnavailableException 
   * @throws SQLException           If the database cannot be reached, the
   *                                exception is thrown
   * @throws InputMismatchException If the specified item cannot be found in the
   *                                inventory catalog, the exception is thrown
   */
  public ItemDTO getItemDTOFromDatabase(int itemIdentifier) throws ItemCatalogUnavailableException, FaultyItemIdentifierException {
    String content;

    if (!getConnectionToDatabase()) {
      try {
        throw new SQLException();
      } catch (SQLException e) {
        content = "Exception " + e + "was thrown. Database is unavailable";
        throw new ItemCatalogUnavailableException(this.FILE_NAME_ERROR_LOGS, content);        
      }
    }

    if (Integer.toString(itemIdentifier).equals("123456")) {
      return new ItemDTO(itemIdentifier, 29.90, 0.06, "BigWheel Oatmeal",
          "BigWheel Oatmeal 500g, whole grain oats, high fiber , gluten free");
    } else if (Integer.toString(itemIdentifier).equals("567890")) {
      return new ItemDTO(itemIdentifier, 14.90, 0.06, "YouGoGo Blueberry",
          "YouGoGo Blueberry 240g, low sugar youghurt, blueberry flavour");
    }

    try {
      throw new InputMismatchException();
    } catch (InputMismatchException e) {
      content = "No item found with " + itemIdentifier + " identifier in the inventory catalog.";
      throw new FaultyItemIdentifierException(this.FILE_NAME_ERROR_LOGS, content);
    }
  }
}