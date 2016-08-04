package numbersIntoWords;

public class NumberToTextConverterUpTo99 {
  static final String[] IN_WORDS =
      new String[] {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
          "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
          "eighteen", "nineteen"};
  static final String[] TENS_IN_WORDS =
      {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
  public static final int BASE_NUMBER = 10;

  public static String convert(int number) {
    if (number == 0)
      return "zero";
    return convertForGreaterThanZero(number);
  }

  static String convertForGreaterThanZero(int number) {
    if (itIsLessThan19(number)) {
      return convertForUpTo19(number);
    }

    if (itIsMultiplesOfBaseNumber(number)) {
      return convertForMultiplesOfBaseNumber(getOffset(number));
    }

    return convertForRemaining(number);
  }

  static boolean itIsLessThan19(int number) {
    return number <= 19;
  }

  static String convertForUpTo19(int number) {
    return IN_WORDS[number];
  }

  static boolean itIsMultiplesOfBaseNumber(int number) {
    return number % BASE_NUMBER == 0;
  }

  static String convertForRemaining(int number) {
    return convertForMultiplesOfBaseNumber(getOffset(number)) + " " + convertForUpTo19(
        getRemainingNumber(number));
  }

  static String convertForMultiplesOfBaseNumber(int offset) {
    return TENS_IN_WORDS[offset - 1];
  }

  static int getOffset(int number) {
    return number / BASE_NUMBER;
  }

  static int getRemainingNumber(int number) {
    return number - (BASE_NUMBER * getOffset(number));
  }
}
