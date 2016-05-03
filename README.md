# Coding-Kata
Coding Kata Examples

## Multibuy Checkout
based on Kata @ http://codekata.com/kata/kata09-back-to-the-checkout/

Given the stubb.

```java
public class Checkout {

  PricingRule pricingRule;

  public Checkout(PricingRule pricingRule) {

  }

  public void scan(Item item) {

  }

  public double getTotal() {
      return 0.0;
  }

}
```

Write the code and tests to support multibuy special pricing of a mixed basket.

```
  Item   Unit      Special
         Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15
```

How can different pricing rules be supported?
