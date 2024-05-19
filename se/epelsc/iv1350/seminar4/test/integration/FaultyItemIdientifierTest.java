package se.epelsc.iv1350.seminar4.test.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar4.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.seminar4.source.integration.FaultyItemIdentifierException;
import se.epelsc.iv1350.seminar4.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

public class FaultyItemIdientifierTest {
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
  public void testFaultyItemIdentifier() {
    assertThrows(FaultyItemIdentifierException.class, () -> new Item(this.instanceToTest.getItemDTOFromDatabase(13579)));
  }
}
