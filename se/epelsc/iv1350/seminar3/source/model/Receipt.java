package se.epelsc.iv1350.seminar3.source.model;

import java.text.DecimalFormat;

public class Receipt {
  private String starterString;
  private String endString;
  private String[][] receiptRows;
  private Sale sale;
  private double cashPaid;
  private String currency;

  // Constructor
  public Receipt(Sale sale) {
    this.starterString = "------------------ BEGIN RECEIPT ------------------";
    this.endString = "------------------ END RECEIPT ------------------";
    this.sale = sale;
    this.currency = "SEK";
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
    this.receiptRows = new String[sale.getTotalItems()][5];

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

    for (int i = 0; i < receiptRows.length; i++) {
      String[] row = receiptRows[i];
      if (row[0] != null) {
        System.out.printf("%-30s %-10s %-10s %-5s %-10s%n", row[0], row[1], row[2], row[3], this.currency);
      }
    }

    System.out.println();
    System.out.printf("%-52s %-5s %-10s %n", "Total:", outputTotalCostOfSale(), this.currency);
    System.out.println("VAT: " + roundTwoDecimalPoints(Double.parseDouble(outputTotalVatOfSale())));
    System.out.println();
    System.out.printf("%-52s %-5s %-10s %n" ,"Cash:", this.cashPaid, this.currency);

    String change = String.valueOf(this.cashPaid - Double.parseDouble(outputTotalCostOfSale()));

    System.out.printf("%-52s %-5s %-10s %n" ,"Change:", roundTwoDecimalPoints(Double.parseDouble(change)), this.currency);

    System.out.println(this.endString);

    System.out.println();
    System.out.println("Change to give the customer: " + roundTwoDecimalPoints(Double.parseDouble(change)) + " " + this.currency);
    System.out.println();
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
      totalCost += this.sale.getItem(i).getTotalItemPrice();
    }

    return String.valueOf(totalCost);
  }

  private String outputTotalVatOfSale() {
    double totalVAT = 0;
    double totalCostOfProduct;
    double VAT;

    for (int i = 0; i < receiptRows.length; i++) {
      totalCostOfProduct = this.sale.getItem(i).getTotalItemPrice();
      VAT = Double.parseDouble(this.receiptRows[i][4]);

      totalVAT += (totalCostOfProduct * VAT);
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

  /*
   * Function rounds a double value to two decimal points
   */
  public String roundTwoDecimalPoints(double valueToRound) {
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(valueToRound);
  }

  public String getCurrency() {
    return this.currency;
  }
}
