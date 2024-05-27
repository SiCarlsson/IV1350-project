package se.epelsc.iv1350.higherGradeTasks.source.model;

import se.epelsc.iv1350.higherGradeTasks.source.util.Calculations;

public class Receipt {
  private String starterString;
  private String endString;
  private String[][] receiptRows;
  private Sale sale;
  private double cashPaid;
  private String currency;

  /**
   * Constructor
   * 
   * @param sale An instance of sale
   */
  public Receipt(Sale sale) {
    this.starterString = "------------------ BEGIN RECEIPT ------------------";
    this.endString = "------------------- END RECEIPT -------------------";
    this.sale = sale;
    this.currency = "SEK";
  }

  /**
   * Function that builds the receipt
   */
  public void createReceipt() {
    addItemsToReceipt();
    sendReceiptToOutput();
  }

  /**
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

  /**
   * Function to send the receipt to output
   */
  private void sendReceiptToOutput() {
    System.out.println(this.starterString);
    System.out.println("Time of Sale: " + outputCurrentTime());
    System.out.println();

    for (int i = 0; i < receiptRows.length; i++) {
      String[] row = receiptRows[i];
      if (row[0] != null) {
        System.out.printf("%-25s %-1s %-11s %-5s %-10s%n", row[0], row[1] + " x", Calculations.roundTwoDecimalPoints(Double.parseDouble(row[2])), Calculations.roundTwoDecimalPoints(Double.parseDouble(row[3])), this.currency);
      }
    }

    System.out.println();
    System.out.printf("%-41s %-5s %-10s %n", "Total:", Calculations.roundTwoDecimalPoints(Double.parseDouble(outputTotalCostOfSale())), this.currency);
    System.out.printf("%-41s %-5s %n", "VAT:", Calculations.roundTwoDecimalPoints(Double.parseDouble(outputTotalVatOfSale())));
    System.out.println();
    System.out.printf("%-41s %-5s %-10s %n", "Cash:", this.cashPaid, this.currency);

    String change = String.valueOf(this.cashPaid - Double.parseDouble(outputTotalCostOfSale()));

    System.out.printf("%-41s %-5s %-10s %n", "Change:", Calculations.roundTwoDecimalPoints(Double.parseDouble(change)),
        this.currency);

    System.out.println(this.endString);

    System.out.println();
    System.out.println(
        "Change to give the customer: " + Calculations.roundTwoDecimalPoints(Double.parseDouble(change)) + " " + this.currency);
    System.out.println();
  }

  /**
   * Function returns the current time
   * 
   * @return The current time as a String
   */
  private String outputCurrentTime() {
    return this.sale.getTimeOfSale();
  }

  /**
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

  /**
   * Function calculates the total VAT of a sale
   * 
   * @return The total VAT of a sale as a String
   */
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

  /**
   * Function gets the current sale
   * 
   * @return The sale instance
   */
  public Sale getCurrentSale() {
    return this.sale;
  }

  /**
   * Function returns the receipt rows
   * 
   * @return The 2D String array containg all reciept information
   */
  public String[][] getReceiptRows() {
    return this.receiptRows;
  }

  /**
   * Function to set the value of cashPaid
   * 
   * @param cashRecieved The amount of cash recieved from the customer
   */
  public void setCashPaid(double cashRecieved) {
    this.cashPaid = cashRecieved;
  }

  /**
   * Getter function to retrieve the currency used on the receipt
   * 
   * @return The currency in String format
   */
  public String getCurrency() {
    return this.currency;
  }
}
