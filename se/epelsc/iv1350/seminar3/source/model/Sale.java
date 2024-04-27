package se.epelsc.iv1350.seminar3.source.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sale {
  // Variables
  private String currentTime;
  private Receipt receipt;
  private Item[] items;

  /*
   * Constructor
   */
  public Sale() {
    this.items = new Item[0];
    this.currentTime = getTimeOfSale();
  }

  /*
   * A function that returns a receipt based on the current state of the sale
   * 
   * @return the instance of the receipt for the current sale
   */
  public Receipt getReceipt() {
    this.receipt = new Receipt(this);
    return this.receipt;
  }

  /*
   * A function to get the current time of a sale
   * 
   * @return the current time in java.time.LocalTime format
   */
  public String getTimeOfSale() {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return currentTime.format(formatter);
  }

  /*
   * Send a request to the printer to print a receipt
   * 
   * @params All information that should be on the receipt
   */
  public void printReceipt(Receipt receipt) {

  }

  /*
   * Adds an item to a current sale, also handles if item already exists
   * 
   * @param item An instance of item containing the item that should be addded
   */
  public void addItem(Item item) {
    if (checkItemAlreadyExists(item)) {
      addToExistingItem(item.getItentifier());
    } else {
      this.items = expandArray();
      insertItem(item);
    }
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
   * @param item The item that should be added to a sale
   */
  private void insertItem(Item item) {
    int lastIndexPositionOfArray = this.items.length - 1;
    this.items[lastIndexPositionOfArray] = item;
  }

  /*
   * Function to see if an item already exists in the sale
   */
  private boolean checkItemAlreadyExists(Item item) {
    int itemIdentifier = item.getItentifier();

    for (int i = 0; i < this.items.length; i++) {
      if (itemIdentifier == this.items[i].getItentifier()) {
        return true;
      }
    }

    return false;
  }

  private void addToExistingItem(int itemIdentifier) {
    for (int i = 0; i < this.items.length; i++) {
      if (itemIdentifier == this.items[i].getItentifier()) {
        this.items[i].incrementAmount();
      }
    }
  }

  /*
   * Function gets the total amount of products in a sale
   * 
   * @return The amount of items in the current sale
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