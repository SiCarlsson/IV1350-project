package se.epelsc.iv1350.higherGradeTasks.tests.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemDTO;
import se.epelsc.iv1350.higherGradeTasks.source.model.Item;
import se.epelsc.iv1350.higherGradeTasks.source.model.Receipt;
import se.epelsc.iv1350.higherGradeTasks.source.model.Sale;
import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RecieptTest {
  private Sale sale;
  private Receipt instanceToTest;
  private ItemDTO decoyItemDTO;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void preSetUp() {
    System.setOut(new PrintStream(outContent));
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
    System.setOut(originalOut);
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
  public void testCorrectReceiptPrintOneProduct() {
    int itemIdentifier = 123456;
    double itemPrice = 24.9;
    String itemName = "sampleItem1";

    double VAT = 0.06;

    this.sale.addItem(new ItemDTO(itemIdentifier, itemPrice, VAT, itemName,
        null));
    this.sale.addItem(new ItemDTO(itemIdentifier, itemPrice, VAT, itemName,
        null));

    Item item = this.sale.getItem(0);

    double cashReceivedFromCustomer = 200;
    this.instanceToTest.setCashPaid(cashReceivedFromCustomer);

    String change = Double.toString(cashReceivedFromCustomer - this.sale.getSaleInfo().getTotalCostOfSale())
        .replaceAll(",", ".");

    this.instanceToTest.createReceipt();

    String expectedStartString = "------------------ BEGIN RECEIPT ------------------";
    String expectedEndString = "------------------- END RECEIPT -------------------";
    String expectedTimeOfSale = this.sale.getTimeOfSale();
    String expectedItemRow = String.format("%-25s %-1s %-11s %-5s %-10s%n", item.getName(), item.getAmount() + " x",
        Calculations.roundTwoDecimalPoints(item.getPrice()),
        Calculations.roundTwoDecimalPoints(item.getTotalItemPrice()), this.instanceToTest.getCurrency());
    String expectedTotalRow = String.format("%-41s %-5s %-10s %n", "Total:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(this.instanceToTest.outputTotalCostOfSale())),
        this.instanceToTest.getCurrency());
    String expectedVATRow = String.format("%-41s %-5s %n", "VAT:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(this.instanceToTest.outputTotalVatOfSale())));
    String expectedCashRow = String.format("%-41s %-5s %-10s %n", "Cash:", cashReceivedFromCustomer, this.instanceToTest
        .getCurrency());
    String expectedChangeRow = String.format("%-41s %-5s %-10s %n", "Change:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(change)), this.instanceToTest
            .getCurrency());

    assertTrue(outContent.toString().contains(expectedStartString),
        "The start string does not match the receipt output");
    assertTrue(outContent.toString().contains(expectedTimeOfSale), "The time of sale is not correct");
    assertTrue(outContent.toString().contains(expectedItemRow), "The time of sale is not correct");
    assertTrue(outContent.toString().contains(expectedTotalRow), "The total row does not print properly");
    assertTrue(outContent.toString().contains(expectedVATRow), "The VAT row does not print properly");
    assertTrue(outContent.toString().contains(expectedCashRow), "The cash row does not print properly");
    assertTrue(outContent.toString().contains(expectedChangeRow), "The change row does not print properly");
    assertTrue(outContent.toString().contains(expectedEndString), "The end string does not match the receipt output");
  }

  @Test
  public void testCorrectReceiptPrintMultipleProducts() {
    int firstItemIdentifier = 123456;
    double firstItemPrice = 24.9;
    String firstItemName = "sampleItem1";

    int secondItemIdentifier = 567890;
    double secondItemPrice = 14.9;
    String secondItemName = "sampleItem2";

    double VAT = 0.06;

    this.sale.addItem(new ItemDTO(firstItemIdentifier, firstItemPrice, VAT, firstItemName,
        null));
    this.sale.addItem(new ItemDTO(firstItemIdentifier, firstItemPrice, VAT, firstItemName,
        null));
    this.sale.addItem(new ItemDTO(secondItemIdentifier, secondItemPrice, VAT, secondItemName,
        null));

    Item firstItem = this.sale.getItem(0);
    Item secondItem = this.sale.getItem(1);

    double cashReceivedFromCustomer = 200;
    this.instanceToTest.setCashPaid(cashReceivedFromCustomer);

    String change = Double.toString(cashReceivedFromCustomer - this.sale.getSaleInfo().getTotalCostOfSale())
        .replaceAll(",", ".");

    this.instanceToTest.createReceipt();

    String expectedStartString = "------------------ BEGIN RECEIPT ------------------";
    String expectedEndString = "------------------- END RECEIPT -------------------";
    String expectedTimeOfSale = this.sale.getTimeOfSale();

    String firstExpectedItemRow = String.format("%-25s %-1s %-11s %-5s %-10s%n", firstItem.getName(),
        firstItem.getAmount() + " x",
        Calculations.roundTwoDecimalPoints(firstItem.getPrice()),
        Calculations.roundTwoDecimalPoints(firstItem.getTotalItemPrice()), this.instanceToTest.getCurrency());

    String secondExpectedItemRow = String.format("%-25s %-1s %-11s %-5s %-10s%n", secondItem.getName(),
        secondItem.getAmount() + " x",
        Calculations.roundTwoDecimalPoints(secondItem.getPrice()),
        Calculations.roundTwoDecimalPoints(secondItem.getTotalItemPrice()), this.instanceToTest.getCurrency());

    String expectedTotalRow = String.format("%-41s %-5s %-10s %n", "Total:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(this.instanceToTest.outputTotalCostOfSale())),
        this.instanceToTest.getCurrency());
    String expectedVATRow = String.format("%-41s %-5s %n", "VAT:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(this.instanceToTest.outputTotalVatOfSale())));
    String expectedCashRow = String.format("%-41s %-5s %-10s %n", "Cash:", cashReceivedFromCustomer,
        this.instanceToTest
            .getCurrency());
    String expectedChangeRow = String.format("%-41s %-5s %-10s %n", "Change:",
        Calculations.roundTwoDecimalPoints(Double.parseDouble(change)), this.instanceToTest
            .getCurrency());

    assertTrue(outContent.toString().contains(expectedStartString),
        "The start string does not match the receipt output");
    assertTrue(outContent.toString().contains(expectedStartString), "The end string does not match the receipt output");
    assertTrue(outContent.toString().contains(expectedTimeOfSale), "The time of sale is not correct");

    assertTrue(outContent.toString().contains(firstExpectedItemRow), "The first item row is not correct");
    assertTrue(outContent.toString().contains(secondExpectedItemRow), "The second item row is not correct");

    assertTrue(outContent.toString().contains(expectedTotalRow), "The total row does not print properly");
    assertTrue(outContent.toString().contains(expectedVATRow), "The VAT row does not print properly");
    assertTrue(outContent.toString().contains(expectedCashRow), "The cash row does not print properly");
    assertTrue(outContent.toString().contains(expectedChangeRow), "The change row does not print properly");
  }
}
