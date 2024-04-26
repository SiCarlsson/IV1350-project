package se.epelsc.iv1350.seminar3.test.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar3.source.controller.Controller;
import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
  private Controller instanceToTest;
  private Item decoyItem;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Controller(new Printer());
    this.decoyItem = new Item(new ItemDTO(12345, 0, 0, null, null));
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
    this.decoyItem = null;
  }

  @Test
  public void testStartSale() {
    this.instanceToTest.startSale();

    assertNotEquals(null, this.instanceToTest.getSale(), "Basic functionallity of startSale works!");
  }

  @Test
  public void testAddItemToSaleWithOneSpecificProduct() {
    this.instanceToTest.startSale();
    int expectedOutput = 12345;
    this.instanceToTest.addItemToSale(expectedOutput);
    int givenOutput = this.instanceToTest.getSale().getItem(0).getItentifier();

    assertEquals(expectedOutput, givenOutput, "Controller can add an item to the current sale!");
  }

  @Test
  public void testAddItemToSaleWithMultipleProducts() {
    this.instanceToTest.startSale();
    
    int productIdentifierForFirstProduct, expectedOutputFirstProduct;
    productIdentifierForFirstProduct = expectedOutputFirstProduct = 12345;

    int productIdentifierForSecondProduct, expectedOutputSecondProduct;
    productIdentifierForSecondProduct = expectedOutputSecondProduct = 67890;
    
    this.instanceToTest.addItemToSale(productIdentifierForFirstProduct);
    this.instanceToTest.addItemToSale(productIdentifierForSecondProduct);

    int givenOutputFirstProduct = this.instanceToTest.getSale().getItem(0).getItentifier();
    int givenOutputSecondProduct = this.instanceToTest.getSale().getItem(1).getItentifier();

    assertEquals(expectedOutputFirstProduct, givenOutputFirstProduct, "");
    assertEquals(expectedOutputSecondProduct, givenOutputSecondProduct, "Controller can add multiple items to the current sale!");
  }
}
