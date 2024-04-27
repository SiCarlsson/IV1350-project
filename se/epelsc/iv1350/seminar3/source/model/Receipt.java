package se.epelsc.iv1350.seminar3.source.model;

public class Receipt {
  private String starterString;
  private String endString;
  private String[][] receiptRows;
  private Sale sale;

  // Constructor
  public Receipt(Sale sale) {
    this.starterString = "------------------ BEGIN RECEIPT ------------------";
    this.endString = "------------------ END RECEIPT ------------------";
    this.receiptRows = new String[sale.getTotalItems()][4];
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
    }
  }

  /*
   * Function to send the receipt to output
   */
  private void sendReceiptToOutput() {
    System.out.println(this.starterString);

    System.out.println(this.endString);
  }

  /*
   * Function returns the current sale
   */
  public Sale getCurrentSale() {
    return this.sale;
  }

  /*
   * function returns the reciept rows
   */
  public String[][] getRecieptRows() {
    return this.receiptRows;
  }
}
