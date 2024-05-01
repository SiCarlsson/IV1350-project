package se.epelsc.iv1350.seminar3.source.startup;

import se.epelsc.iv1350.seminar3.source.controller.Controller;
import se.epelsc.iv1350.seminar3.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar3.source.integration.Printer;
import se.epelsc.iv1350.seminar3.source.view.View;

public class Main {
  // Main function, will run on initialization

  public static void main(String[] args) {
    
    Printer printer = new Printer();
    ExternalSystemCreator exSysCreator = new ExternalSystemCreator();
    Controller contr = new Controller(printer, exSysCreator);
    View view = new View(contr);

    contr.startSale();
    contr.addItemToSale(123456);
    contr.addItemToSale(123456);
    contr.addItemToSale(567890);
    
    contr.getSale().getReceipt().createReceipt();
  }
}
