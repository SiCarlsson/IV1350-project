package se.epelsc.iv1350.seminar3.test.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.model.Item;
import se.epelsc.iv1350.seminar3.source.model.Receipt;
import se.epelsc.iv1350.seminar3.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class RecieptTest {
  private Sale sale;
  private Receipt instanceToTest;
  private Item decoyItem;

  @Before
  public void preSetUp() {
    this.sale = new Sale();
  }

  @BeforeEach
  public void setUp() {
    this.sale = new Sale();
    this.decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
  }

  @AfterEach
  public void tearDown() {
    this.sale = null;
    this.decoyItem = null;
  }

  @Test
  public void testAddItemsToReceiptCorrectOutput() {
    String expectedName = "Apple";
    int amount = 2;
    double price = 12.50;
    double totalPrice = amount * price;

    this.decoyItem = new Item(new ItemDTO(12345, price, 0, expectedName, null));

    this.sale.addItem(decoyItem);
    this.sale.addItem(decoyItem);

    this.instanceToTest = this.sale.getReceipt();
    this.instanceToTest.createReceipt();

    String expectedAmount = Integer.toString(amount);
    String expectedPrice = String.valueOf(price);
    String expectedTotalPrice = String.valueOf(totalPrice);

    assertEquals(expectedName, this.instanceToTest.getRecieptRows()[0][0]);
    assertEquals(expectedAmount, this.instanceToTest.getRecieptRows()[0][1]);
    assertEquals(expectedPrice, this.instanceToTest.getRecieptRows()[0][2]);
    assertEquals(expectedTotalPrice, this.instanceToTest.getRecieptRows()[0][3]);
  }
}
