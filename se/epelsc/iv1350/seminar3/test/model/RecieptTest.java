package se.epelsc.iv1350.seminar3.test.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;
import se.epelsc.iv1350.seminar3.source.model.Receipt;
import se.epelsc.iv1350.seminar3.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class RecieptTest {
  private Sale sale;
  private Receipt instanceToTest;
  private ItemDTO decoyItemDTO;

  @Before
  public void preSetUp() {
    this.sale = new Sale();
    this.instanceToTest = new Receipt(sale);
  }

  @BeforeEach
  public void setUp() {
    this.sale = new Sale();
    this.instanceToTest = new Receipt(sale);
    this.decoyItemDTO = new ItemDTO(12345, 0, 0, null, null);
  }

  @AfterEach
  public void tearDown() {
    this.sale = null;
    this.instanceToTest = null;
    this.decoyItemDTO = null;
  }

  @Test
  public void testAddItemsToReceiptCorrectOutput() {
    String expectedName = "Apple";
    int amount = 2;
    double price = 12.50;
    double VAT = 0.25;
    double totalPrice = amount * price;

    this.decoyItemDTO = new ItemDTO(12345, price, VAT, expectedName, null);

    this.sale.addItem(this.decoyItemDTO);
    this.sale.addItem(this.decoyItemDTO);

    this.instanceToTest = this.sale.getReceipt();
    this.instanceToTest.createReceipt();

    String expectedAmount = Integer.toString(amount);
    String expectedPrice = String.valueOf(price);
    String expectedVAT = String.valueOf(VAT);
    String expectedTotalPrice = String.valueOf(totalPrice);

    assertEquals(expectedName, this.instanceToTest.getReceiptRows()[0][0], "Name did not output correctly");
    assertEquals(expectedAmount, this.instanceToTest.getReceiptRows()[0][1], "Amount did not output correctly");
    assertEquals(expectedPrice, this.instanceToTest.getReceiptRows()[0][2], "Price did not output correctly");
    assertEquals(expectedTotalPrice, this.instanceToTest.getReceiptRows()[0][3],
        "Total price did not output correctly");
    assertEquals(expectedVAT, this.instanceToTest.getReceiptRows()[0][4], "VAT did not output correctly");
  }

  @Test
  public void testOutputTotalCostOfSale() {
    double priceOfFirstProduct = 35;
    double priceOfSecondProduct = 75.43;
    double priceOfThirdProduct = 12.19;

    this.sale.addItem(new ItemDTO(1, priceOfFirstProduct, 0, null, null));
    this.sale.addItem(new ItemDTO(2, priceOfSecondProduct, 0, null, null));
    this.sale.addItem(new ItemDTO(3, priceOfThirdProduct, 0, null, null));

    this.instanceToTest = this.sale.getReceipt();
    this.instanceToTest.createReceipt();

    double sumOfProducts = priceOfFirstProduct + priceOfSecondProduct + priceOfThirdProduct;
    String expectedOutput = String.valueOf(sumOfProducts);

    String givenOutput = this.instanceToTest.outputTotalCostOfSale();

    assertEquals(expectedOutput, givenOutput, "Output total cost of sale gets it wrong");
  }

  @Test
  public void testRoundTwoDecimalPoints() {
    String firstExpectedOutut = "5,87";
    String secondExpectedOutut = "13,37";
    String thirdExpectedOutut = "9,13";
    double firstValueToBeRounded = 5.874664;
    double secondValueToBeRounded = 13.3712357;
    double thirdValueToBeRounded = 9.129765;

    assertEquals(firstExpectedOutut, this.instanceToTest.roundTwoDecimalPoints(firstValueToBeRounded),
        "Rounding did not work as intended");
    assertEquals(secondExpectedOutut, this.instanceToTest.roundTwoDecimalPoints(secondValueToBeRounded),
        "Rounding did not work as intended");
    assertEquals(thirdExpectedOutut, this.instanceToTest.roundTwoDecimalPoints(thirdValueToBeRounded),
        "Rounding did not work as intended");
  }
}
