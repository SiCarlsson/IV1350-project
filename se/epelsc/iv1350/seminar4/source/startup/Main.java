package se.epelsc.iv1350.seminar4.source.startup;

import java.io.IOException;

import se.epelsc.iv1350.seminar4.source.controller.Controller;
import se.epelsc.iv1350.seminar4.source.integration.ExternalSystemCreator;
import se.epelsc.iv1350.seminar4.source.integration.Printer;
import se.epelsc.iv1350.seminar4.source.view.View;

public class Main {
  /**
   * Main method, runs on execution of the program
   * 
   * @param args Arguments for the program that is enterd on execution
   * @throws IOException if textfile cannot be created
   */
  public static void main(String[] args) throws IOException {

    Printer printer = new Printer();
    ExternalSystemCreator exSysCreator = new ExternalSystemCreator();
    Controller contr = new Controller(printer, exSysCreator);
    View view = new View(contr);

    view.cashierStartsSale();
    view.cashierAddsItem(123456);
    view.cashierAddsItem(123456);
    view.cashierAddsItem(567890);
    view.cashierEndSale(100);

    view.cashierStartsSale();
    view.cashierAddsItem(123456);
    view.cashierAddsItem(123456);
    view.cashierAddsItem(567890);
    view.cashierEndSale(100);

    view.cashierStartsSale();
    view.cashierAddsItem(123456);
    view.cashierAddsItem(123456);
    view.cashierAddsItem(567890);
    view.cashierEndSale(100);
  }
}
