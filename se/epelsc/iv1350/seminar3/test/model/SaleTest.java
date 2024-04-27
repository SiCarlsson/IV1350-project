package se.epelsc.iv1350.seminar3.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
  private Sale instanceToTest;
  private Item decoyItem;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Sale();
    this.decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
  }
  
  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
    this.decoyItem = null;
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
  public void testAddItemNotCreatingDuplicatesInSaleItems() {
    int expectedOutput = 1;

    this.instanceToTest.addItem(this.decoyItem);
    this.instanceToTest.addItem(this.decoyItem);
    this.instanceToTest.addItem(this.decoyItem);

    int givenOutput = this.instanceToTest.getTotalItems();

    assertEquals(expectedOutput, givenOutput, "checkItemExists works as expected");
  }

  @Test
  public void testIncrementItemAmount() {
    int expectedOutput = 3;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(this.decoyItem);
    }

    int givenOutput = this.instanceToTest.getItem(0).getAmount();

    assertEquals(expectedOutput, givenOutput, "checkItemExists works as expected");
  }

  //Skipped parameter (it is inside of function)
  @Test
  public void testGetItem() {
    Item expectedOutput = this.decoyItem;

    int indexPosition = 0;

    this.instanceToTest.addItem(expectedOutput);

    Item givenOutput = instanceToTest.getItem(indexPosition);

    assertEquals(expectedOutput, givenOutput, "getItem basic functionallity works as expected!");
  }

  @Test
  public void testGetItemIndexOutOfBoundsUpper() {
    this.instanceToTest.addItem(this.decoyItem);

    int indexPosition = 4;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }

  @Test
  public void testGetItemIndexOutOfBoundsLower() {
    this.instanceToTest.addItem(this.decoyItem);

    int indexPosition = -2;

    assertThrows(IndexOutOfBoundsException.class, () -> this.instanceToTest.getItem(indexPosition));
  }
}