package se.epelsc.iv1350.seminar3.source.model;

public class Receipt {
  private String starterString;
  private String endString;
  private String[][] receiptRows;
  private Sale sale;
  private double cashPaid;

  // Constructor
  public Receipt(Sale sale) {
    this.starterString = "------------------ BEGIN RECEIPT ------------------";
    this.endString = "------------------ END RECEIPT ------------------";
    this.receiptRows = new String[sale.getTotalItems()][5];
    this.sale = sale;
  }

  /*
   * Function that builds the receipt
   */
  public void createReceipt() {
    addItemsToReceipt();
    sendReceiptToOutput();
  }

  /*
   * Function that adds all items from sale to the receipt in the correct format
   */
  private void addItemsToReceipt() {
    for (int i = 0; i < receiptRows.length; i++) {
      receiptRows[i][0] = this.sale.getItem(i).getName();
      receiptRows[i][1] = Integer.toString(this.sale.getItem(i).getAmount());
      receiptRows[i][2] = String.valueOf(this.sale.getItem(i).getPrice());
      receiptRows[i][3] = String.valueOf(this.sale.getItem(i).getTotalItemPrice());
      receiptRows[i][4] = String.valueOf(this.sale.getItem(i).getVAT());
    }
  }

  /*
   * Function to send the receipt to output
   */
  private void sendReceiptToOutput() {
    System.out.println(this.starterString);

    System.out.println("Time of Sale: " + outputCurrentTime());

    System.out.println();
    System.out.println();

    for (int i = 0; i < receiptRows.length; i++) {
      String[] row = receiptRows[i];
      if (row[0] != null) {
        System.out.printf("%-12s %-10s %-8s %-10s%n", row[0], row[1], row[2], row[3]);
      }
    }

    System.out.println("Total: " + outputTotalCostOfSale());
    System.out.println("VAT: " + outputTotalVatOfSale());
    System.out.println();
    System.out.println("Cash: " + this.cashPaid);

    String change = String.valueOf(this.cashPaid - Double.parseDouble(outputTotalCostOfSale()));

    System.out.println("Change: " + change);
    System.out.println(this.endString);

    System.out.println();
    System.out.println("Change to give the customer: " + change);
  }

  /*
   * Function returns the current time
   * 
   * @return The current time as a String
   */
  private String outputCurrentTime() {
    return this.sale.getTimeOfSale();
  }

  /*
   * Function calculates the total cost of a sale and returns the value
   * 
   * @return The total cost of a sale as a String
   */
  public String outputTotalCostOfSale() {
    double totalCost = 0;

    for (int i = 0; i < receiptRows.length; i++) {
      totalCost += Double.parseDouble(receiptRows[i][3]);
    }

    return String.valueOf(totalCost);
  }

  private String outputTotalVatOfSale() {
    double totalVAT = 0;
    double totalCostOfProduct;
    double VAT;

    for (int i = 0; i < receiptRows.length; i++) {
      totalCostOfProduct = Double.parseDouble(this.receiptRows[i][3]);
      VAT = Double.parseDouble(this.receiptRows[i][4]);

      totalVAT += totalCostOfProduct * VAT;
    }

    return String.valueOf(totalVAT);
  }

  /*
   * Function returns the current sale
   */
  public Sale getCurrentSale() {
    return this.sale;
  }

  /*
   * function returns the receipt rows
   */
  public String[][] getReceiptRows() {
    return this.receiptRows;
  }

  /*
   * Function to set the value of cashPaid
   * 
   * @param cashRecieved The amount of cash recieved from the customer
   */
  public void setCashPaid(double cashRecieved) {
    this.cashPaid = cashRecieved;
  }
}
