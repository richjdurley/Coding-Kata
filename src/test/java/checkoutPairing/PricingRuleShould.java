package checkoutPairing;

import org.junit.Test;

import static checkoutPairing.Item.ITEM_A;
import static checkoutPairing.Item.ITEM_B;
import static checkoutPairing.Item.ITEM_D;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rich on 04/08/2016.
 */
public class PricingRuleShould {

  @Test
  public void returnUnitPriceForDefaultPrice() {
    PricingRule pricingRule = new PricingRule(ITEM_D, ITEM_D.getPrice(), 1);
    assertThat(pricingRule.getTotalPrice(ITEM_D, 1), is(ITEM_D.getPrice()));
  }

  @Test
  public void return45AsPriceForTwoUnitsOfItemB() {
    PricingRule pricingRule = new PricingRule(ITEM_B, 45.0, 2);
    assertThat(pricingRule.getTotalPrice(ITEM_B, 2), is(45.0));
  }

  @Test
  public void return75AsPriceForThreeUnitsOfItemB() {
    PricingRule pricingRule = new PricingRule(ITEM_B, 45.0, 2);
    assertThat(pricingRule.getTotalPrice(ITEM_B, 3), is(75.0));
  }

  @Test
  public void return90AsPriceForFourUnitsOfItemB() {
    PricingRule pricingRule = new PricingRule(ITEM_B, 45.0, 2);
    assertThat(pricingRule.getTotalPrice(ITEM_B, 4), is(90.0));
  }

  @Test
  public void return120AsPriceForFiveUnitsOfItemB() {
    PricingRule pricingRule = new PricingRule(ITEM_B, 45.0, 2);
    assertThat(pricingRule.getTotalPrice(ITEM_B, 5), is(120.0));
  }

  @Test
  public void return130AsPriceForThreeUnitsOfItemA() {
    PricingRule pricingRule = new PricingRule(ITEM_A, 130, 3);
    assertThat(pricingRule.getTotalPrice(ITEM_A, 3), is(130.0));
  }

  @Test
  public void return230AsPriceForFiveUnitsOfItemA() {
    PricingRule pricingRule = new PricingRule(ITEM_A, 130, 3);
    assertThat(pricingRule.getTotalPrice(ITEM_A, 5), is(230.0));
  }




}
