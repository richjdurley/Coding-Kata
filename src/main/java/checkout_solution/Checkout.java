package checkout_solution;

public class Checkout {

  PricingRule pricingRule;
  Basket basket;

  double total;

  public Checkout() {
    total=0.0d;
    basket=new Basket();
  }

  public Checkout(PricingRule pricingRule) {
    total=0.0d;
    basket=new Basket();
    this.pricingRule = pricingRule;
  }

  public void scan(Item item) {
    this.basket.add(item);
    if (pricingRule!=null)
      total+= pricingRule.applyPriceRule(item, this.basket);
    else
      total+= item.getPrice();

  }

  public double getTotal() {
      return total;
  }

  public Basket getBasket() {
    return basket;
  }

}
