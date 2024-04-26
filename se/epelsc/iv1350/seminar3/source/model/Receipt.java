package se.epelsc.iv1350.seminar3.source.model;

public class Receipt {
  private String starterString;
  private String endString;

  // Constructor
  public Receipt() {
    this.starterString = "------------------ BEGIN RECEIPT ------------------";
    this.endString = "------------------ END RECEIPT ------------------";
  }

  /*
   * Function that builds the receipt
   */
  public void createReceipt(Item[] items) {
    System.err.println(this.starterString);



    System.err.println(this.endString);
  }
}
