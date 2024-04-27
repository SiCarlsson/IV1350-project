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
    double VAT = 0.25;
    double totalPrice = amount * price;

    this.decoyItem = new Item(new ItemDTO(12345, price, VAT, expectedName, null));

    this.sale.addItem(decoyItem);
    this.sale.addItem(decoyItem);

    this.instanceToTest = this.sale.getReceipt();
    this.instanceToTest.createReceipt();

    String expectedAmount = Integer.toString(amount);
    String expectedPrice = String.valueOf(price);
    String expectedVAT = String.valueOf(VAT);
    String expectedTotalPrice = String.valueOf(totalPrice);

    assertEquals(expectedName, this.instanceToTest.getReceiptRows()[0][0]);
    assertEquals(expectedAmount, this.instanceToTest.getReceiptRows()[0][1]);
    assertEquals(expectedPrice, this.instanceToTest.getReceiptRows()[0][2]);
    assertEquals(expectedTotalPrice, this.instanceToTest.getReceiptRows()[0][3]);
    assertEquals(expectedVAT, this.instanceToTest.getReceiptRows()[0][4]);
  }
}