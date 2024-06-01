package se.epelsc.iv1350.higherGradeTasks.tests.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar4.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.seminar4.source.integration.ItemCatalogUnavailableException;
import se.epelsc.iv1350.seminar4.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ItemCatalogUnavailableExceptionTest {
  private ExternalInventorySystem instanceToTest;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new ExternalInventorySystem();
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
  }

  @Test
  public void testFaultyConnectionToDatabase()  {
    this.instanceToTest.setConnectionToDatabase(false);
    assertThrows(ItemCatalogUnavailableException.class, () -> new Item(this.instanceToTest.getItemDTOFromDatabase(123456)));
  }
}