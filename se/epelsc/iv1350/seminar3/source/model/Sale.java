package se.epelsc.iv1350.seminar3.source.model;

// Importing LocalDateTime class from java.time package 
import java.time.LocalTime;

public class Sale {
  // Variables
  private LocalTime time;
  private Receipt receipt;
  private Item[] items = new Item[0];

  /*
   * Constructor
   */
  public Sale() {
    this.receipt = new Receipt();
  }

  /*
   * A function to get the current recipt of a sale
   * 
   * @return the receipt for the current sale
   */
  public Receipt getReceipt() {
    // TODO: Receipt needs to convert items to an actual receipt
    return this.receipt;
  }

  /*
   * A function to get the current time of a sale
   * 
   * @return the current time in java.time.LocalTime format
   */
  public LocalTime getTimeOfSale() {
    setTime();
    return time;
  }

  /*
   * A function to set the current time
   */
  private void setTime() {
    this.time = LocalTime.now();
  }

  /*
   * Send a request to the printer to print a receipt
   * 
   * @params All information that should be on the receipt
   */
  public void printReceipt(Receipt receipt) {
    // insert code here
  }

  /*
   * Prepares to make a payment, no further inserts of products
   */
  public void makePayment() {
    // insert code here
  }

  /*
   * Adds an item to a current sale
   * 
   * @param item An instance of item containing the item that should be addded
   */
  public void addItem(Item item) {
    this.items = expandArray();
    insertItem(item);
  }

  /*
   * Function to expand the current array holding all products in a sale
   */
  private Item[] expandArray() {
    int oldLenghtOfArray = this.items.length;

    Item[] newArrayWithItems = new Item[oldLenghtOfArray + 1];

    for (int i = 0; i < oldLenghtOfArray; i++) {
      newArrayWithItems[i] = this.items[i];
    }

    return newArrayWithItems;
  }

  /*
   * Function handles logic to add an item to a current sale
   * 
   * @ param item The item that should be added to a sale
   */
  private void insertItem(Item item) {
    int lastIndexPositionOfArray = this.items.length - 1;
    this.items[lastIndexPositionOfArray] = item;
  }

  /*
   * Function gets the total amount of products in a sale
   */
  public int getTotalItems() {
    int counter = 0;
    for (int i = 0; i < this.items.length; i++) {
      counter++;
    }
    return counter;
  }

  /*
   * Function gets the inted of a given item
   * 
   * @param indexPosition The index position of a product
   * 
   * @return The specified item in the sale
   */
  public Item getItem(int indexPosition) throws IndexOutOfBoundsException {
    int totalNumberOfProducts = this.items.length - 1;

    if (indexPosition < 0 || indexPosition > totalNumberOfProducts)
      throw new IndexOutOfBoundsException("Index specified does not exist!");

    return items[indexPosition];
  }
}