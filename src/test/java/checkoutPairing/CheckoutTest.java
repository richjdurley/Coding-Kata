package checkoutPairing;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Rich on 28/07/2016.
 */
public class CheckoutTest {

  private Checkout checkout;

  @Before
  public void setup() {
    checkout = new Checkout(new PricingRule(null, 0d, 2));
  }

  @Test
  public void checkoutTotalIsZeroWhenNoItemsAreScanned() {
    //given
    //when
    //then
    assertThat(checkout.getTotal(), is(0d));
  }

  @Test
  public void checkoutTotalIs15WhenItemDIsScannedIn() {
    checkout.scan(new Item("D", 15d));
    assertThat(checkout.getTotal(), is(15d));
  }

  @Test
  public void checkoutTotalIs35WhenItemDAndCIsScannedIn() {
    checkout.scan(Item.ITEM_D);
    checkout.scan(Item.ITEM_C);
    assertThat(checkout.getTotal(), is(35d));
  }

  @Test
  public void checkoutTotalIs45WhenTwoItemBAreScanned() {
    checkout.scan(Item.ITEM_B);
    checkout.scan(Item.ITEM_B);
    assertThat(checkout.getTotal(), is(45d));
  }

//  @Test
//  public void checkoutTotalIs130WhenThreeItemAAreScanned() {
//    checkout.scan(Item.ITEM_A);
//    checkout.scan(Item.ITEM_A);
//    checkout.scan(Item.ITEM_A);
//    assertThat(checkout.getTotal(), is(130d));
//  }*/
}
