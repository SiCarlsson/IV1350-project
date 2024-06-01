package se.epelsc.iv1350.seminar4.source.integration;

import java.sql.SQLException;

public class ItemCatalogUnavailableException extends SQLException {
  public ItemCatalogUnavailableException(String s) {
    super(s);
  }
}
