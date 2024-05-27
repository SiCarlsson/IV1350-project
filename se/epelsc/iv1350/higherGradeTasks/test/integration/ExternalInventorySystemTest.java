package se.epelsc.iv1350.higherGradeTasks.test.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.higherGradeTasks.source.integration.ExternalInventorySystem;
import se.epelsc.iv1350.higherGradeTasks.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class ExternalInventorySystemTest {
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
  public void testFetchItemFromDatabase() throws InputMismatchException, SQLException {
    
    Item testerItem = new Item(this.instanceToTest.getItemDTOFromDatabase(123456));
    
    String expectedOutput = "BigWheel Oatmeal";
    String givenOutput = testerItem.getName();

    assertEquals(expectedOutput, givenOutput, "item is not fetched correctly");
  }

  @Test
  public void testFaultyItemIdentifier() throws InputMismatchException, SQLException {
    assertThrows(InputMismatchException.class, () -> new Item(this.instanceToTest.getItemDTOFromDatabase(13579)));
  }
}
