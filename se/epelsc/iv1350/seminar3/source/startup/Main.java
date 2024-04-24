package se.epelsc.iv1350.seminar3.source.startup;

import se.epelsc.iv1350.seminar3.source.controller.Controller;
import se.epelsc.iv1350.seminar3.source.integration.Printer;

public class Main {
  // Main function, will run on initialization
  public static void main(String[] args) {
    
    Printer printer = new Printer();
    Controller contr = new Controller(printer);

    contr.startSale();

  }
}
