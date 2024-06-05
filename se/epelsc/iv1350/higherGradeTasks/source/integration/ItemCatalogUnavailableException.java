package se.epelsc.iv1350.higherGradeTasks.source.integration;

import java.sql.SQLException;

public class ItemCatalogUnavailableException extends SQLException {
  /**
   * Constructor
   * 
   * @param s the original error message
   */
  public ItemCatalogUnavailableException(String s) {
    super(s);
  }
}
