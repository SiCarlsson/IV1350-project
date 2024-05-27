package se.epelsc.iv1350.higherGradeTasks.source.integration;

import java.sql.SQLException;

import se.epelsc.iv1350.higherGradeTasks.source.util.Textfiles;

public class ItemCatalogUnavailableException extends SQLException {
  public ItemCatalogUnavailableException(String FILE_NAME, String s) {
    super(s);
    Textfiles.writeToTextFile(FILE_NAME, s);
  }
}
