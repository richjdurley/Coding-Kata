package romanNumerals;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class RomanNumeralsShould {

  private static final String ROMAN_ONE = "I";
  private static final String ROMAN_TWO = "II";
  private static final String ROMAN_THREE = "III";
  private static final String ROMAN_FIVE = "V";
  private static final String ROMAN_TEN = "X";
  private static final String ROMAN_FIFTY = "L";
  private static final String ROMAN_FORTY_NINE = "XLIX";
      ;
  private static int ARABIC_ONE = 1;

  private static int ARABIC_TWO = 2;
  private static int ARABIC_THREE = 3;
  private static final int ARABIC_FIVE = 5;
  private static final int ARABIC_TEN = 10;
  private static final int ARABIC_FIFTY = 50;
  private static final int ARABIC_FORTY_NINE = 49;

  @Test
  public void shouldReturnIWhenGivenArabicOne() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanOne = romanNumeralConverter.convert(ARABIC_ONE);
    //then
    assertThat(romanOne, is(ROMAN_ONE));
  }

  @Test
  public void shouldReturnVWhenGivenArabicFive() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFive = romanNumeralConverter.convert(ARABIC_FIVE);
    //then
    assertThat(romanFive, is(ROMAN_FIVE));
  }

  @Test
  public void shouldReturnXWhenGivenArabicTen() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFive = romanNumeralConverter.convert(ARABIC_TEN);
    //then
    assertThat(romanFive, is(ROMAN_TEN));
  }


  @Test
  public void shouldReturnLWhenGivenArabicFifty() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFifty = romanNumeralConverter.convert(ARABIC_FIFTY);
    //then
    assertThat(romanFifty, is(ROMAN_FIFTY));
  }

  @Test
  public void shouldReturnIIWhenGivenArabicTwo() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFifty = romanNumeralConverter.convert(ARABIC_TWO);
    //then
    assertThat(romanFifty, is(ROMAN_TWO));
  }

  @Test
  public void shouldReturnIIIWhenGivenArabicThree() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFifty = romanNumeralConverter.convert(ARABIC_THREE);
    //then
    assertThat(romanFifty, is(ROMAN_THREE));
  }


  @Test
  public void shouldReturnXLIXWhenGivenArabicFortyNine() {
    //given
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    //when
    String romanFifty = romanNumeralConverter.convert(ARABIC_FORTY_NINE);
    //then
    assertThat(romanFifty, is(ROMAN_FORTY_NINE));
  }

}
