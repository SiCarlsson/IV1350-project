package se.epelsc.iv1350.seminar3.startup;

import se.epelsc.iv1350.seminar3.integration.Printer;
import se.epelsc.iv1350.seminar3.controller.Controller;

public class Main {
  // Main function, will run on initialization
  public static void main(String[] args) {
    
    Printer printer = new Printer();
    Controller contr = new Controller(printer);

    contr.startSale();

  }
}
