package checkoutPairing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

  PricingRule pricingRule;
  private double total;

  public Checkout(PricingRule pricingRule) {
  }

  public void scan(Item item) {
    total+=item.getPrice();
  }

  public double getTotal() {
    return total;
  }
}
