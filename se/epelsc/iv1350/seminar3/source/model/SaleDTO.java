package se.epelsc.iv1350.seminar3.source.model;

public class SaleDTO {
  private Item[] items;

  public SaleDTO(Sale sale) {
    this.items = sale.getItemList();
  }

  public Item[] getItems() {
    return this.items;
  }
}
