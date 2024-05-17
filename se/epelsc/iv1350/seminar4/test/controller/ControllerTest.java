package se.epelsc.iv1350.seminar4.test.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar4.source.controller.Controller;
import se.epelsc.iv1350.seminar4.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar4.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar4.source.integration.Printer;
import se.epelsc.iv1350.seminar4.source.model.Item;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class ControllerTest {
  private Controller instanceToTest;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Controller(new Printer(), ExternalSystemCreator.getInstanceOfExternalSystemCreator());
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
  }

  @Test
  public void testStartSale() {
    this.instanceToTest.startSale();

    assertNotEquals(null, this.instanceToTest.getSale(), "Basic functionallity of startSale does not work as expected");
  }

  @Test
  public void testAddItemToSaleWithOneSpecificProduct() throws InputMismatchException, SQLException {
    this.instanceToTest.startSale();
    int expectedOutput = 123456;
    this.instanceToTest.addItemToSale(expectedOutput);
    int givenOutput = this.instanceToTest.getSale().getItem(0).getItentifier();

    assertEquals(expectedOutput, givenOutput, "The specific item is not added to sale as expected");
  }

  @Test
  public void testAddItemToSaleWithMultipleProducts() throws InputMismatchException, SQLException {
    this.instanceToTest.startSale();
    
    int productIdentifierForFirstProduct, expectedOutputFirstProduct;
    productIdentifierForFirstProduct = expectedOutputFirstProduct = 123456;

    int productIdentifierForSecondProduct, expectedOutputSecondProduct;
    productIdentifierForSecondProduct = expectedOutputSecondProduct = 567890;
    
    this.instanceToTest.addItemToSale(productIdentifierForFirstProduct);
    this.instanceToTest.addItemToSale(productIdentifierForSecondProduct);

    int givenOutputFirstProduct = this.instanceToTest.getSale().getItem(0).getItentifier();
    int givenOutputSecondProduct = this.instanceToTest.getSale().getItem(1).getItentifier();

    assertEquals(expectedOutputFirstProduct, givenOutputFirstProduct, "First product is not added as expected");
    assertEquals(expectedOutputSecondProduct, givenOutputSecondProduct, "Second product is not added as expected");
  }

  @Test
  public void testCreatingInstancesOfExternalSystemsAndDbInConstructor() {
    assertNotEquals(null, this.instanceToTest.getExternalAccountingSytem(), "Accounting system was not created");
    assertNotEquals(null, this.instanceToTest.getExternalDiscountDatabase(), "Discount database was not created");
    assertNotEquals(null, this.instanceToTest.getExternalInventorySystem(), "Inventory system was not created");
  }

  @Test
  public void testHandlePaymentCorrectIncrementInRegister() throws InputMismatchException, SQLException {
    this.instanceToTest.startSale();

    double testedInput = 110.99;
    Item testItem = new Item(new ItemDTO(000000, 29.9, 0.06, null, null));

    double expectedOutput = this.instanceToTest.getRegister().getMoneyInRegister() + testItem.getPrice();

    this.instanceToTest.addItemToSale(123456);
    this.instanceToTest.endSale(testedInput);

    double givenOutput = this.instanceToTest.getRegister().getMoneyInRegister();

    assertEquals(expectedOutput, givenOutput, "Cash in register did not increment as intended after payment");
  }
}
