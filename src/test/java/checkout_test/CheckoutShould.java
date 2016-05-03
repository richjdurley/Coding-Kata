package checkout_test;

import checkout_solution.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class CheckoutShould {

  @Mock
  PricingRule pricingRule;

  @Mock
  Basket basket;

  @InjectMocks
  Checkout mockedCheckout = new Checkout();


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void return0WhenNoScans() {
    //given a new mockedCheckout
    //when no scans
    //then
    Assert.assertTrue(mockedCheckout.getTotal() == 0.0d);
  }

  @Test
  public void returnUnitPriceWhen1Scan() {
    //given
    Item item = mock(Item.class);
    //when
    when(pricingRule.applyPriceRule(item, basket)).thenReturn(1.0d);
    mockedCheckout.scan(item);

    //then
    Assert.assertThat(mockedCheckout.getTotal(), is(1.0d));

  }

  @Test
  public void returnTotalOfUnitPricesWhenScansNotOnPromotion() {
    //given
    Item no_offer_item1 = mock(Item.class);
    Item no_offer_item2 = mock(Item.class);
    Item no_offer_item3 = mock(Item.class);


    //when
    when(pricingRule.applyPriceRule(no_offer_item1, basket)).thenReturn(1.0d);
    when(pricingRule.applyPriceRule(no_offer_item2, basket)).thenReturn(2.0d);
    when(pricingRule.applyPriceRule(no_offer_item3, basket)).thenReturn(3.0d);
    mockedCheckout.scan(no_offer_item1);
    mockedCheckout.scan(no_offer_item2);
    mockedCheckout.scan(no_offer_item3);

    Assert.assertThat(mockedCheckout.getTotal(), is(6.0d));
  }

  @Test
  public void checkBasketAddedToOnScan() {
    //given
    Item item = mock(Item.class);
    PricingRule pricingRule = mock(PricingRule.class);
    Checkout checkout = new Checkout(pricingRule);
    checkout.scan(item);
    assertThat(checkout.getBasket().size(), is(1));

  }

  @Test
  public void appliesSpecialPriceWhen2OnOfferItemsScanned() {
    //given
    Item offer_item1 = mock(Item.class);
    HashMap<Item, Double> specialPriceMap2 = new HashMap<>();
    HashMap<Item, Double> specialPriceMap3 = new HashMap<>();
    specialPriceMap2.put(offer_item1, 15.0d);
    PricingRule multiBuyPricingRule = new MultiBuyPricingRule(specialPriceMap2, specialPriceMap3);
    Checkout checkout = new Checkout(multiBuyPricingRule);

    //when
    when(offer_item1.getPrice()).thenReturn(30.0d);
    scanItemNTimes(2, offer_item1, checkout);

    //then
    Assert.assertThat(checkout.getTotal(), is(45.0d));

  }

  @Test
  public void appliesSpecialPriceWhen3OnOfferItemsScanned() {
    //given
    Item offer_item1 = mock(Item.class);
    HashMap<Item, Double> specialPriceMap2 = new HashMap<>();
    HashMap<Item, Double> specialPriceMap3 = new HashMap<>();

    specialPriceMap3.put(offer_item1, 30.0d);
    PricingRule multiBuyPricingRule = new MultiBuyPricingRule(specialPriceMap2, specialPriceMap3);
    Checkout checkout = new Checkout(multiBuyPricingRule);

    //when
    when(offer_item1.getPrice()).thenReturn(50.0d);

    scanItemNTimes(3, offer_item1, checkout);


    //then
    Assert.assertThat(checkout.getTotal(), is(130.0d));
  }

  @Test
  public void appliesSpecialPricingToMixedBasket() {
    //given
    Item offer_item1 = mock(Item.class);
    Item offer_item2 = mock(Item.class);
    Item no_offer_item3 = mock(Item.class);

    HashMap<Item, Double> specialPriceMap2 = new HashMap<>();
    HashMap<Item, Double> specialPriceMap3 = new HashMap<>();
    specialPriceMap3.put(offer_item1, 15.0d);
    specialPriceMap3.put(offer_item2, 30.0d);

    PricingRule multiBuyPricingRule = new MultiBuyPricingRule(specialPriceMap2, specialPriceMap3);
    Checkout checkout = new Checkout(multiBuyPricingRule);

    //when
    when(offer_item1.getPrice()).thenReturn(30.0d);
    when(offer_item2.getPrice()).thenReturn(50.0d);
    when(no_offer_item3.getPrice()).thenReturn(20.0d);

    scanItemNTimes(3, offer_item1, checkout);

    checkout.scan(no_offer_item3);

    scanItemNTimes(4, offer_item2, checkout);

    //then
    Assert.assertThat(checkout.getTotal(), is(15.0d + 30d + 30d + 20d + 50d + 50d + 30d + 50d));

  }

  @Test
  public void appliesSpecialPriceToMultipleBatchesScanned() {
    //given
    Item offer_item1 = mock(Item.class);
    HashMap<Item, Double> specialPriceMap2 = new HashMap<>();
    HashMap<Item, Double> specialPriceMap3 = new HashMap<>();
    specialPriceMap3.put(offer_item1, 30.0d);
    PricingRule multiBuyPricingRule =
        spy(new MultiBuyPricingRule(specialPriceMap2, specialPriceMap3));
    Checkout checkout = new Checkout(multiBuyPricingRule);

    //when
    when(offer_item1.getPrice()).thenReturn(50.0d);
    scanItemNTimes(6, offer_item1, checkout);

    //then
    Assert.assertThat(checkout.getTotal(), is(260.0d));

  }

  private void scanItemNTimes(int n, Item item, Checkout checkout) {
    for (int i = n; i > 0; i--) {
      checkout.scan(item);
    }

  }

}
