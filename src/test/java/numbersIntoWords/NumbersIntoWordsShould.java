package numbersIntoWords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NumbersIntoWordsShould {

  public NumbersIntoWordsShould(int number, String expectedInWords) {
    this.number = number;
    this.expectedInWords = expectedInWords;
  }

  private int number;
  private String expectedInWords;

  @Parameterized.Parameters(name = "{index}: {0} for_number_zero {1}")
  public static Collection<Object[]> numbersToWordsMap() {
    return Arrays.asList(
        new Object[][] {{0, "zero"}, {1, "one"}, {2, "two"}, {3, "three"}, {4, "four"}, {5, "five"},
            {6, "six"}, {7, "seven"}, {8, "eight"}, {9, "nine"}, {10, "ten"}, {11, "eleven"},
            {12, "twelve"}, {13, "thirteen"}, {14, "fourteen"}, {15, "fifteen"}, {16, "sixteen"},
            {17, "seventeen"}, {18, "eighteen"}, {19, "nineteen"}, {20, "twenty"},
            {21, "twenty one"}, {22, "twenty two"}, {23, "twenty three"}, {24, "twenty four"},
            {25, "twenty five"}, {26, "twenty six"}, {27, "twenty seven"}, {28, "twenty eight"},
            {29, "twenty nine"}, {30, "thirty"}, {31, "thirty one"}, {32, "thirty two"},
            {33, "thirty three"}, {34, "thirty four"}, {35, "thirty five"}, {36, "thirty six"},
            {37, "thirty seven"}, {38, "thirty eight"}, {39, "thirty nine"}, {40, "forty"},
            {41, "forty one"}, {42, "forty two"}, {43, "forty three"}, {44, "forty four"},
            {45, "forty five"}, {46, "forty six"}, {47, "forty seven"}, {48, "forty eight"},
            {49, "forty nine"}, {50, "fifty"}, {60, "sixty"}, {70, "seventy"}, {80, "eighty"},
            {90, "ninety"}, {99, "ninety nine"}, {100, "one hundred"}, {101, "one hundred and one"}});
  }

  @Test
  public void testReturnNumberAsWordsForANumber() {
    assertThat(NumberToTextConverter.convert(number), is(expectedInWords));
  }



}
