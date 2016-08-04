package checkoutPairing;

import java.util.List;

public class PriceService {
  public double price(List<Item> basket) {
    if (basket.isEmpty())
      return 0;
    return basket.get(0).getPrice();
  }
}
