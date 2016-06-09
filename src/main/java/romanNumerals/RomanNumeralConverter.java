package romanNumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

  private enum RomanNumeral {
    I, II, IV, V, IX, X, XL, L, XC, C, CD, D,CM,M;
  }


  private static Map<Integer, RomanNumeral> map = new LinkedHashMap<>();

  static {
    map.put(1000, RomanNumeral.M);
    map.put(900, RomanNumeral.CM);
    map.put(500, RomanNumeral.D);
    map.put(400, RomanNumeral.CD);
    map.put(100, RomanNumeral.C);
    map.put(90, RomanNumeral.XC);
    map.put(50, RomanNumeral.L);
    map.put(40, RomanNumeral.XL);
    map.put(10, RomanNumeral.X);
    map.put(9, RomanNumeral.IX);
    map.put(5, RomanNumeral.V);
    map.put(4, RomanNumeral.IV);
    map.put(2, RomanNumeral.II);
    map.put(1, RomanNumeral.I);
  }

  public String convert(int arabicNumeral) {
    String romanNumeral = "";
    for (Integer v : map.keySet()) {
      while ((arabicNumeral / v) >= 1) {
        romanNumeral = romanNumeral + map.get(v);
        arabicNumeral = arabicNumeral - v;
      }
    }

    return romanNumeral;
  }
}
