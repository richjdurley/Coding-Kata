package checkoutPairing;

public class Item {
  public static final Item ITEM_D = new Item("D", 15d);
  public static final Item ITEM_C = new Item("C", 20d);
  public static final Item ITEM_B = new Item("B", 30d);
  public static final Item ITEM_A = new Item("A", 50d);

  private final String name;
  private final double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
