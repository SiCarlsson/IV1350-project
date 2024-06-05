package se.epelsc.iv1350.higherGradeTasks.source.startup;

import java.util.InputMismatchException;

import se.epelsc.iv1350.higherGradeTasks.source.controller.Controller;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ItemCatalogUnavailableException;
import se.epelsc.iv1350.higherGradeTasks.source.integration.Printer;
import se.epelsc.iv1350.higherGradeTasks.source.view.View;

public class Main {
  /**
   * Main method, runs on execution of the program
   * 
   * @param args Arguments for the program that is enterd on execution
   * @throws InputMismatchException          If the specified item cannot be found
   *                                         in theinventory catalog, the
   *                                         exception is thrown
   * @throws ItemCatalogUnavailableException If the item database cannot be
   *                                         reached, the exception is thrown
   */
  public static void main(String[] args) throws InputMismatchException, ItemCatalogUnavailableException {
    Printer printer = new Printer();
    ExternalSystemCreator exSysCreator = ExternalSystemCreator.getInstanceOfExternalSystemCreator();
    Controller contr = new Controller(printer, exSysCreator);
    View view = new View(contr);

    view.sampleRunOfThreeSales();
  }
}
