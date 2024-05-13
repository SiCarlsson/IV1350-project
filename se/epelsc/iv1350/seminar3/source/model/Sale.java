package se.epelsc.iv1350.seminar3.source.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.epelsc.iv1350.seminar3.source.integration.ItemDTO;

public class Sale {
  private Receipt receipt;
  private Item[] items;

  /**
   * Constructor
   */
  public Sale() {
    this.items = new Item[0];
    this.receipt = new Receipt(this);
  }

  /**
   * A function that returns a receipt based on the current state of the sale
   * 
   * @return the instance of the receipt for the current sale
   */
  public Receipt getReceipt() {
    return this.receipt;
  }

  /**
   * A function to get the current time of a sale
   * 
   * @return the current time in java.time.LocalTime format
   */
  public String getTimeOfSale() {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return currentTime.format(formatter);
  }

  /**
   * Adds an item to a current sale, also handles if item already exists
   * 
   * @param item An instance of item containing the item that should be addded
   */
  public void addItem(ItemDTO itemDTO) {
    Item newItem = new Item(itemDTO);
    if (checkItemAlreadyExists(newItem)) {
      addToExistingItem(newItem.getItentifier());
    } else {
      this.items = expandArray();
      insertItem(newItem);
    }
  }

  /**
   * Function to expand the current array holding all products in a sale
   * 
   * @return An expanded array holding all the items in the current sale
   */
  private Item[] expandArray() {
    int oldLenghtOfArray = this.items.length;

    Item[] newArrayWithItems = new Item[oldLenghtOfArray + 1];

    for (int i = 0; i < oldLenghtOfArray; i++) {
      newArrayWithItems[i] = this.items[i];
    }

    return newArrayWithItems;
  }

  /**
   * Function handles logic to add an item to a current sale
   * 
   * @param item The item that should be added to a sale
   */
  private void insertItem(Item item) {
    int lastIndexPositionOfArray = this.items.length - 1;
    this.items[lastIndexPositionOfArray] = item;
  }

  /**
   * Function to see if an item already exists in the sale
   * 
   * 
   * @param item An item that should be looked at if it already exists in the sale
   * 
   * @return A true or false value depending on if item exists or not in the
   * current sale
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

  /**
   * Function increments the amount of an item
   * 
   * @param itemIdentifier Holds the identifier of an item that should be
   * incremented in amount
   */
  private void addToExistingItem(int itemIdentifier) {
    for (int i = 0; i < this.items.length; i++) {
      if (itemIdentifier == this.items[i].getItentifier()) {
        this.items[i].incrementAmount();
      }
    }
  }

  /**
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

  /**
   * Function gets the index of a given item
   * 
   * @param indexPosition The index position of a product
   * 
   * @return The specified item in the sale
   * 
   * @throws IndexOutOfBoundsException if the index position is negative or
   * exceeds the range of available items
   */
  public Item getItem(int indexPosition) throws IndexOutOfBoundsException {
    int totalNumberOfProducts = this.items.length - 1;

    if (indexPosition < 0 || indexPosition > totalNumberOfProducts)
      throw new IndexOutOfBoundsException("Index specified does not exist!");

    return items[indexPosition];
  }

  /**
   * Function gets all items from the current sale
   * 
   * @return The basket of items of the current sale
   */
  public Item[] getAllItemsFromCurrentSale() {
    return this.items;
  }

  /**
   * Function handles the loging of a sale
   * 
   * @param itemIdentifier Holds an identifier for an item
   */
  public void outputSaleLog(int itemIdentifier) {
    Item lastItem = getItemByItemID(itemIdentifier);

    System.out.println("Add 1 item with id " + lastItem.getItentifier() + ":");
    System.out.println("Item ID: " + lastItem.getItentifier());
    System.out.println("Item name: " + lastItem.getName());
    System.out.println("Item cost: " + lastItem.getPrice() + " " + this.receipt.getCurrency());
    System.out.println("VAT: " + (lastItem.getVAT() * 100) + "%");
    System.out.println("Item description: " + lastItem.getDescription());
    System.out.println();
    System.out.println("Total cost (incl VAT): " + getTotalSalePrice() + " " + this.receipt.getCurrency());
    System.out.println(
        "Total VAT:             " + this.receipt.roundTwoDecimalPoints(getTotalVATOfSale())
            + " " + this.receipt.getCurrency());
    System.out.println();
  }

  /**
   * Function to increment total price of sale as items are added
   * 
   * @return the total price after all current items are added
   */
  private double getTotalSalePrice(){
    double totalPriceOfSale = 0;

    for(int i = 0; i < this.items.length; i++){
      totalPriceOfSale += this.items[i].getPrice() * this.items[i].getAmount();
    }
    return totalPriceOfSale;
  }

   /**
   * Function to increment total VAT of sale as items are added
   * 
   * @return the total VAT after all current items are added
   */
  private double getTotalVATOfSale(){
    double totalVATOfSale = 0;

    for(int i = 0; i < this.items.length; i++){
      totalVATOfSale += this.items[i].getVAT() * this.items[i].getAmount() * this.items[i].getPrice();
    }
    return totalVATOfSale;
  }

  /**
   * Function gets the item of a sale based on the itemIdentifier
   * 
   * @param itemIdentifier Holds an identifier for an item
   * 
   * @return The item specified in a sale
   */
  private Item getItemByItemID(int itemIdentifier) {
    int i = 0;
    while (!(this.items[i].getItentifier() == itemIdentifier)) {
      i++;
    }
    return items[i];
  }

  /**
   * Function handles logging regarding the end of a sale
   * 
   * @param cashRevievedFromCustomer The amount of money handed by the customer
   */
  public void endCurrentSale(double cashRecievedFromCustomer) {
    outputLogsEndSale(cashRecievedFromCustomer);
  }

  /**
   * Function handles all logging regarding the end of a current sale
   * 
   * @param cashRecievedFromCustomer The amount of money handed by the customer
   */
  private void outputLogsEndSale(double cashRecievedFromCustomer) {
    System.out.println("End sale:");
    System.out.println("Total cost (incl VAT): " + getTotalSalePrice() + " " + this.receipt.getCurrency());
    System.out.println();
    
    System.out.println("Customer pays " + cashRecievedFromCustomer + " " + this.receipt.getCurrency() + ":");
    System.out.println("Sent sale info to external accounting system.");

    for (int i = 0; i < this.items.length; i++) {
      int itemIdentifier = this.items[i].getItentifier();
      int itemAmount = this.items[i].getAmount();

      System.out.println("Told external inventory system to decrease inventory quantity of item " + itemIdentifier
          + " by " + itemAmount + " units.");
    }
    System.out.println();
  }
}