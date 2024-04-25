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

  /*
   * Tests the functionallity of adding items to the current sale
   * 
   * @return
   */
  @Test
  public void testAddItem() {
    int expectedOutput = 4;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(null);
    }

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "addItem works as expected!");
  }

  /*
   * Tests the basic functionality of getItem
   */
  @Test
  public void testGetItem() {
    Item expectedOutput = new Item(new ItemDTO(12345, 0, 0, null, null));

    int indexPosition = 0;

    this.instanceToTest.addItem(expectedOutput);

    Item givenOutput = instanceToTest.getItem(indexPosition);

    assertEquals(expectedOutput, givenOutput, "getItem basic functionallity works as expected!");
  }

  /*
   * Testing if getItem can handle an index value larger than allowed
   */
  @Test
  public void testGetItemIndexOutOfBoundsUpper() {
    Item decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
    this.instanceToTest.addItem(decoyItem);

    int indexPosition = 4;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }

  /*
   * Testing if getItem can handle an index value smaller than allowed
   */
  @Test
  public void testGetItemIndexOutOfBoundsLower() {
    Item decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
    this.instanceToTest.addItem(decoyItem);

    int indexPosition = -2;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }
}