package checkout_solution;

import java.util.HashMap;

public class MultiBuyPricingRule implements PricingRule {

  private HashMap<Item, Double> itemSpecialPriceFor2 = new HashMap<Item, Double>();
  private HashMap<Item, Double> itemSpecialPriceFor3 = new HashMap<Item, Double>();

  public MultiBuyPricingRule(HashMap<Item, Double> specialPriceFor2Items,
      HashMap<Item, Double> specialPriceFor3Items) {
    itemSpecialPriceFor2 = specialPriceFor2Items;
    itemSpecialPriceFor3 = specialPriceFor3Items;

  }

  public double applyPriceRule(Item currentItem, Basket basket) {
    int matchcount = 0;
    Double specialprice;
    for (Item matchedItem : basket) {
      if (matchedItem.equals(currentItem)) {
        matchcount++;
      }
    }

    if (matchcount % 3 == 0) {
      if ((specialprice = itemSpecialPriceFor3.get(currentItem)) != null)
        return specialprice;
    }

    if (matchcount % 2 == 0) {
      if ((specialprice = itemSpecialPriceFor2.get(currentItem)) != null)
        return specialprice;
    }

    return currentItem.getPrice();

  }

}
