package jcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumberParser {
  private boolean roman;
  private boolean negative;
  private int arg1;
  private int arg2;

  public void parse(String arg) {
    Pattern p = Pattern.compile("^([I|V|X|L|C|D|M|0-9]+)\\s+([\\+|\\-|\\*|\\/])\\s+([I|V|X|L|C|D|M|0-9]+)$");
    Matcher m = p.matcher(arg.trim());
    if (m.find()) {
      arg1 = this.parseNumber(m.group(1));
      boolean is_roman = roman;
      arg2 = this.parseNumber(m.group(3));
      if (is_roman != roman) {
        System.out.println("Оба числа должны быть одного типа(Арабские | Римские)");
        return;
      }
      int result;
      switch (m.group(2)) {
        case "+":
          result = arg1 + arg2;
          break;
        case "-":
          result = arg1 - arg2;
          negative = result < 0;
          break;
        case "*":
          result = arg1 * arg2;
          break;
        case "/":
          result = Math.round(arg1 / arg2);
          break;
        default:
          System.out.println("Что-то пошло не так!");
          return;
      }
      if (roman) {
        System.out.println("Результат: -" + RomanParser.generate(Math.abs(result)));
      } else {
        System.out.println("Результат: " + String.valueOf(result));
      }
    } else {
      System.out.println("Вы ввели недопустимое выражение!!!");
    }
  }
  private int parseNumber(String arg) {
    try {
      roman = false;
      return Integer.parseInt(arg);
    } catch (NumberFormatException e) {
      roman = true;
      return RomanParser.parse(arg);
    }
  }
}
