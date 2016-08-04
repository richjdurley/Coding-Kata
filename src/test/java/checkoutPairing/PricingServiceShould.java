package checkoutPairing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PricingServiceShould {

  @Test
  public void priceEmptyBasketIsZero() {
    PriceService priceService = new PriceService();
    List<Item> basket = new ArrayList<>();
    assertThat(priceService.price(basket), is(0d));
  }

  @Test
  public void priceBasketWithOneItemAsUnitPrice() {
    PriceService priceService = new PriceService();
    List<Item> basket = new ArrayList<>();
    basket.add(Item.ITEM_A);
    assertThat(priceService.price(basket), is(Item.ITEM_A.getPrice()));
  }
}
