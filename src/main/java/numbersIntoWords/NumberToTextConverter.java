package numbersIntoWords;

public class NumberToTextConverter {

  public static final int ONE_HUNDRED = 100;
  public static final String ONE_HUNDRED_AS_TEXT = "one hundred";

  public static String convert(int number) {
    if (number < ONE_HUNDRED)
      return NumberToTextConverterUpTo99.convert(number);
    if (number == ONE_HUNDRED)
      return ONE_HUNDRED_AS_TEXT;
    return ONE_HUNDRED_AS_TEXT + " and " + NumberToTextConverterUpTo99.convert(number-ONE_HUNDRED);
  }
}
