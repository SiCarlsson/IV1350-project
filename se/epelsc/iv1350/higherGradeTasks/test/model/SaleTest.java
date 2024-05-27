package se.epelsc.iv1350.higherGradeTasks.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemDTO;
import se.epelsc.iv1350.higherGradeTasks.source.model.Item;
import se.epelsc.iv1350.higherGradeTasks.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
  private Sale instanceToTest;
  private ItemDTO decoyItemDTO;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Sale();
    this.decoyItemDTO = new ItemDTO(12345, 0, 0, null, null);
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
    this.decoyItemDTO = null;
  }

  @Test
  public void testAddItemToSale() {
    int expectedOutput = 4;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(new ItemDTO(i, 0, 0, null, null));
    }

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "addItem does not add the item as expected");
  }

  
  @Test
  public void testAddItemNotCreatingDuplicatesInSaleItems() {
    int expectedOutput = 1;

    this.instanceToTest.addItem(this.decoyItemDTO);
    this.instanceToTest.addItem(this.decoyItemDTO);
    this.instanceToTest.addItem(this.decoyItemDTO);

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "addItem creates duplicates of same item");
  }

  @Test
  public void testIncrementItemAmount() {
    int expectedOutput = 3;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(this.decoyItemDTO);
    }

    int givenOutput = this.instanceToTest.getItem(0).getAmount();

    assertEquals(expectedOutput, givenOutput, "incrementation is not done as expected");
  }

  @Test
  public void testGetItem() {
    ItemDTO expectedOutput = this.decoyItemDTO;

    int indexPosition = 0;

    this.instanceToTest.addItem(expectedOutput);

    Item givenOutput = instanceToTest.getItem(indexPosition);

    assertInstanceOf(Item.class, givenOutput, "getItem returns the wrong type");
  }

  @Test
  public void testGetItemIndexOutOfBoundsUpper() {
    this.instanceToTest.addItem(this.decoyItemDTO);

    int indexPosition = 4;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition), "Index is out of upper bounds");
  }

  @Test
  public void testGetItemIndexOutOfBoundsLower() {
    this.instanceToTest.addItem(this.decoyItemDTO);

    int indexPosition = -2;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition), "Index is out ouf lower bounds");
  }

  @Test
  public void testCurrentTimeFormat() {
    String expectedFormat = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
    String currentTime = instanceToTest.getTimeOfSale();
    assertEquals(true, currentTime.matches(expectedFormat), "Current time was not formated as expected");
  }

  @Test
  public void testCurrentTimeNotNull() {
    String currentTime = instanceToTest.getTimeOfSale();
    assertEquals(false, currentTime.isEmpty(), "Current time is null");
  }
}