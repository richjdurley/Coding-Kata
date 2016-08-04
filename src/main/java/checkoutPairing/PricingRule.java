package checkoutPairing;

public class PricingRule {

  private final Item item;
  private final double price;
  private int quantity;


  public PricingRule(Item item, double price, int quantity) {
    this.item = item;
    this.price = price;
    this.quantity = quantity;
  }

  public double getTotalPrice(Item item, int quantity) {
    int discountedItems = quantity / this.quantity;
    int remainingItems = quantity % this.quantity;
    return (discountedItems * price) + (remainingItems * item.getPrice());
  }
}
