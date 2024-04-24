package startup;

import controller.Controller;

public class Main {
  // Main function, will run on initialization
  public static void main(String[] args) {
    
    Printer printer = new Printer();
    Controller contr = new Controller(printer);

    contr.startSale();

  }
}
