package checkout_solution;

public interface PricingRule {
  double applyPriceRule(Item currentItem, Basket basket);
}
