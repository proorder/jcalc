package jcalc;

import java.util.HashMap;
import java.util.Map;

class RomanParser {
  public static Map<Character, Integer> NUMB = new HashMap<Character, Integer>();
  public static Map<Integer, String> NUMERIC = new HashMap<Integer, String>();

  static {
    NUMB.put('I', 1);
    NUMB.put('V', 5);
    NUMB.put('X', 10);
    NUMB.put('L', 50);
    NUMB.put('C', 100);
    NUMB.put('D', 500);
    NUMB.put('M', 1000);
  }

  static {
    NUMERIC.put(0, "");
    NUMERIC.put(1, "I");
    NUMERIC.put(2, "II");
    NUMERIC.put(3, "III");
    NUMERIC.put(4, "IV");
    NUMERIC.put(5, "V");
    NUMERIC.put(6, "VI");
    NUMERIC.put(7, "VII");
    NUMERIC.put(8, "VIII");
    NUMERIC.put(9, "IX");
  }

  public static int parse(String arg) {
    int result = 0;
    int temp = 0;
    for (int i = 0; i < arg.length(); i++) {
      int numb = RomanParser.NUMB.get(arg.charAt(i));
      if (i < arg.length() - 1) {
        int next = RomanParser.NUMB.get(arg.charAt(i+1));
        if (numb > next) {
          if (temp != 0) {
            temp += numb;
            result += temp;
            temp = 0;
          } else {
            result += numb;
          }
        } else {
          temp += numb;
          if (numb < next) {
            result -= temp;
            temp = 0;
          }
        }
      } else {
        if (temp != 0) {
          temp += numb;
          result += temp;
          temp = 0;
        } else {
          result += numb;
        }
      }
    }
    return result;
  }

  public static String generate(int arg) {
    if (arg >= 100) {
      int count = (int) Character.getNumericValue(String.valueOf(arg).charAt(1));
      String result = "C";
      for (int i = 0; i < count; i++) {
        result += "X";
      }
      result += RomanParser.NUMERIC.get((int) Character.getNumericValue(String.valueOf(arg).charAt(2)));
      return result;
    } else if (arg >= 50) {
      int count = (int) Character.getNumericValue(String.valueOf(arg).charAt(0));
      String result = "L";
      for (int i = 5; i < count; i++) {
        result += "X";
      }
      result += RomanParser.NUMERIC.get((int) Character.getNumericValue(String.valueOf(arg).charAt(1)));
      return result;
    } else if (arg >= 10) {
      int count = (int) Character.getNumericValue(String.valueOf(arg).charAt(0));
      String result = "";
      for (int i = 0; i < count; i++) {
        result += "X";
      }
      result += RomanParser.NUMERIC.get((int) Character.getNumericValue(String.valueOf(arg).charAt(1)));
      return result;
    } else {
      return RomanParser.NUMERIC.get(arg);
    }
  }
}
