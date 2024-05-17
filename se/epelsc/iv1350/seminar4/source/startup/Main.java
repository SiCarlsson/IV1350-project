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
    ExternalSystemCreator exSysCreator = ExternalSystemCreator.getInstanceOfExternalSystemCreator();
    Controller contr = new Controller(printer, exSysCreator);
    View view = new View(contr);

    final int firstSampleProductIdentifier = 123456;
    final int secondSampleProductIdentifier = 567890;
    final int firstSampleDiscountIdentifier = 123456;
    final int secondSampleDiscountIdentifier = 567890;
    final int thirdSampleDiscountIdentifier = 135790;
    final int cashRecievedFromCustomer = 100;


    view.cashierStartsSale();
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(secondSampleProductIdentifier);
    view.userApplicableForDiscount(firstSampleDiscountIdentifier);
    view.cashierEndSale(cashRecievedFromCustomer);

    view.cashierStartsSale();
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(secondSampleProductIdentifier);
    view.userApplicableForDiscount(secondSampleDiscountIdentifier);
    view.cashierEndSale(cashRecievedFromCustomer);

    view.cashierStartsSale();
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(firstSampleProductIdentifier);
    view.cashierAddsItem(secondSampleProductIdentifier);
    view.userApplicableForDiscount(thirdSampleDiscountIdentifier);
    view.cashierEndSale(cashRecievedFromCustomer);
  }
}
