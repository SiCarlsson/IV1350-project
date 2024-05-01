package se.epelsc.iv1350.seminar3.test.model;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
  private Item instanceToTest;

  @AfterEach
  public void tearDown() {
    instanceToTest = null;
  }

  @Test
  public void testCreateNewItem() {
    int expectedIdentifier = 1234;
    double expectedPrice = 12.67;
    double expectedVAT = 0.06;
    String expectedName = "Apple";
    String expectedDescription = "This is an apple";
    int expectedAmount = 1;

    this.instanceToTest = new Item(
        new ItemDTO(expectedIdentifier, expectedPrice, expectedVAT, expectedName, expectedDescription));

    assertEquals(expectedName, this.instanceToTest.getName(), "Name could not be set as intended");
    assertEquals(expectedIdentifier, this.instanceToTest.getItentifier(), "Identifier could not be set as intended");
    assertEquals(expectedAmount, this.instanceToTest.getAmount(), "Amount could not be set as intended");
    assertEquals(expectedPrice, this.instanceToTest.getPrice(), "Price could not be set as intended");
    assertEquals(expectedDescription, this.instanceToTest.getDescription(), "Description could not be set as intended");
    assertEquals(expectedVAT, this.instanceToTest.getVAT(), "VAT could not be set as intended");
  }

  @Test
  public void testGetTotalItemPriceAndIncrementAmount() {
    int amountOfItem = 3;
    double itemPrice = 34.99;

      this.instanceToTest = new Item(new ItemDTO(12345, itemPrice, 0, null, null));
      
      for (int i = 1; i < amountOfItem; i++) {
        this.instanceToTest.incrementAmount();
      }
      
      double expectedTotalPrice = amountOfItem * itemPrice;

      double actualTotalPrice = this.instanceToTest.getTotalItemPrice();

      assertEquals(expectedTotalPrice, actualTotalPrice, "Increment amount does not work properly");
  }
}
