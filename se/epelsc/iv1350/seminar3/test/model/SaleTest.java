package se.epelsc.iv1350.seminar3.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
  /*
   * Variables
   */
  private Sale instanceToTest;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Sale();
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
  }

  @Test
  public void testAddItemToSale() {
    int expectedOutput = 4;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(new Item(new ItemDTO(i, 0, 0, null, null)));
    }

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "addItem works as expected!");
  }

  //Skipped parameter (it is inside of function)
  @Test
  public void testNotCreatingDuplicatesWhenAddingSameItems() {
    Item decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));

    int expectedOutput = 1;

    this.instanceToTest.addItem(decoyItem);
    this.instanceToTest.addItem(decoyItem);
    this.instanceToTest.addItem(decoyItem);

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "checkItemExists works as expected");
  }

  @Test
  public void testIncrementItemAmount() {
    int itemIdentifier = 12345;
    Item decoyItem = new Item(new ItemDTO(itemIdentifier, 0, 0, null, null));

    int expectedOutput = 3;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(decoyItem);
    }

    int givenOutput = this.instanceToTest.getItem(0).getAmount();

    assertEquals(expectedOutput, givenOutput, "checkItemExists works as expected");
  }

  //Skipped parameter (it is inside of function)
  @Test
  public void testGetItem() {
    Item expectedOutput = new Item(new ItemDTO(12345, 0, 0, null, null));

    int indexPosition = 0;

    this.instanceToTest.addItem(expectedOutput);

    Item givenOutput = instanceToTest.getItem(indexPosition);

    assertEquals(expectedOutput, givenOutput, "getItem basic functionallity works as expected!");
  }

  @Test
  public void testGetItemIndexOutOfBoundsUpper() {
    Item decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
    this.instanceToTest.addItem(decoyItem);

    int indexPosition = 4;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }

  @Test
  public void testGetItemIndexOutOfBoundsLower() {
    Item decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
    this.instanceToTest.addItem(decoyItem);

    int indexPosition = -2;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }
}