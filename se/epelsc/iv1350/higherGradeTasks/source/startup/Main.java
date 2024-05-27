package se.epelsc.iv1350.higherGradeTasks.source.startup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

import se.epelsc.iv1350.higherGradeTasks.source.controller.Controller;
import se.epelsc.iv1350.higherGradeTasks.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.higherGradeTasks.source.integration.Printer;
import se.epelsc.iv1350.higherGradeTasks.source.view.View;

public class Main {
  /**
   * Main method, runs on execution of the program
   * 
   * @param args Arguments for the program that is enterd on execution
   * @throws IOException            if textfile cannot be created
   * @throws SQLException           If the database cannot be reached, the
   *                                exception is thrown
   * @throws InputMismatchException If the specified item cannot be found in the
   *                                inventory catalog, the exception is thrown
   */
  public static void main(String[] args) throws InputMismatchException, SQLException {
    Printer printer = new Printer();
    ExternalSystemCreator exSysCreator = ExternalSystemCreator.getInstanceOfExternalSystemCreator();
    Controller contr = new Controller(printer, exSysCreator);
    View view = new View(contr);

    view.sampleRunOfThreeSales();
  }
}
