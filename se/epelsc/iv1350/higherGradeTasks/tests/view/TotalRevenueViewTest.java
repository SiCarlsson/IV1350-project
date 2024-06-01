package se.epelsc.iv1350.higherGradeTasks.tests.view;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.higherGradeTasks.source.controller.Controller;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.higherGradeTasks.source.integration.FaultyItemIdentifierException;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemCatalogUnavailableException;
import se.epelsc.iv1350.higherGradeTasks.source.integration.Printer;
import se.epelsc.iv1350.higherGradeTasks.source.model.Item;
import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;
import se.epelsc.iv1350.higherGradeTasks.source.view.View;

public class TotalRevenueViewTest {
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

  @After
  public void tearDown() {
    this.contr = null;
    this.instanceToTest = null;
    System.setOut(originalOut);
  }

  @Test
  public void testCorrectTotalRevenueOutput() throws FaultyItemIdentifierException, ItemCatalogUnavailableException {
    int firstItemIdentifier = 123456;
    int secondItemIdentifier = 567890;
    this.instanceToTest.cashierAddsItem(firstItemIdentifier);
    this.instanceToTest.cashierAddsItem(firstItemIdentifier);
    this.instanceToTest.cashierAddsItem(secondItemIdentifier);

    Item firstItem = this.contr.getSale().getItem(0);
    Item secondItem = this.contr.getSale().getItem(1);

    double cashReceivedFromCustomer = 100;
    this.instanceToTest.cashierEndSale(cashReceivedFromCustomer);

    String expectedOutput = "Total revenue: "
        + Calculations.roundTwoDecimalPoints(firstItem.getTotalItemPrice() + secondItem.getTotalItemPrice()) + " SEK";

    String givenOutput = outContent.toString();

    assertTrue("Total revenue prints wrongfully", givenOutput.contains(expectedOutput));

  }
}
