package se.epelsc.iv1350.higherGradeTasks.tests.view;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.higherGradeTasks.source.controller.Controller;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.higherGradeTasks.source.integration.FaultyItemIdentifierException;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemCatalogUnavailableException;
import se.epelsc.iv1350.higherGradeTasks.source.integration.Printer;
import se.epelsc.iv1350.higherGradeTasks.source.model.Item;
import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;
import se.epelsc.iv1350.higherGradeTasks.source.view.View;

public class ViewTest {
  Controller contr;
  View instanceToTest;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void preSetUp() {
    System.setOut(new PrintStream(outContent));
    this.contr = new Controller(new Printer(), ExternalSystemCreator.getInstanceOfExternalSystemCreator());
    this.instanceToTest = new View(contr);
    this.instanceToTest.cashierStartsSale();
  }

  @BeforeEach
  public void setUp() {
    this.contr = new Controller(new Printer(), ExternalSystemCreator.getInstanceOfExternalSystemCreator());
    this.instanceToTest = new View(contr);
    this.instanceToTest.cashierStartsSale();
  }

  @AfterEach
  public void tearDown() {
    this.contr = null;
    this.instanceToTest = null;
    System.setOut(originalOut);
  }

  @Test
  public void testCashierAddsItemCorrectSaleLog()
      throws FaultyItemIdentifierException, ItemCatalogUnavailableException {
    int itemIdentifier = 123456;
    this.instanceToTest.cashierAddsItem(itemIdentifier);

    Item item = this.contr.getSale().getItem(0);

    String expectedOutput = "Add 1 item with id " + item.getItentifier() + ":\n" +
        "Item ID: " + item.getItentifier() + "\n" +
        "Item name: " + item.getName() + "\n" +
        "Item cost: " + item.getPrice() + " SEK\n" +
        "VAT: " + item.getVAT() * 100 + "%\n" +
        "Item description: " + item.getDescription() + "\n" +
        "\n" +
        "Total cost (incl VAT): " + item.getPrice() + " SEK\n" +
        "Total VAT: " + Calculations.roundTwoDecimalPoints(item.getVAT() * item.getPrice()) + " SEK\n\n";

    assertEquals(expectedOutput, outContent.toString(), "There is an error in the sale log output");
  }

  @Test
  public void testCashierEndsSaleCorrectEndSaleLogs()
      throws FaultyItemIdentifierException, ItemCatalogUnavailableException {
    int firstItemIdentifier = 123456;
    int secondItemIdentifier = 567890;
    this.instanceToTest.cashierAddsItem(firstItemIdentifier);
    this.instanceToTest.cashierAddsItem(firstItemIdentifier);
    this.instanceToTest.cashierAddsItem(secondItemIdentifier);

    Item firstItem = this.contr.getSale().getItem(0);
    Item secondItem = this.contr.getSale().getItem(1);

    double cashReceivedFromCustomer = 100;
    this.instanceToTest.cashierEndSale(cashReceivedFromCustomer);

    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("End sale:\n").append("Total cost (incl VAT): ")
        .append(Calculations.roundTwoDecimalPoints(firstItem.getTotalItemPrice() + secondItem.getTotalItemPrice()))
        .append(" SEK\n\n")
        .append("Customer pays ").append(cashReceivedFromCustomer).append(" SEK:\n")
        .append("Sent sale info to external accounting system.\n")
        .append("Told external inventory system to decrease inventory quantity of item ")
        .append(firstItem.getItentifier()).append(" by ").append(firstItem.getAmount()).append(" units.\n")
        .append("Told external inventory system to decrease inventory quantity of item ")
        .append(secondItem.getItentifier()).append(" by ").append(secondItem.getAmount()).append(" units.\n");

    String expectedOutput = strBuilder.toString();
    String givenOutput = outContent.toString();

    assertTrue("End sale log is not working properly", givenOutput.contains(expectedOutput));
  }
}
