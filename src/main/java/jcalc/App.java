package jcalc;

public class App {
    public static void main(String[] args) {
      try {
        if (args.length == 0) {
          System.out.println("Вы не указали аргументы");
          return;
        }
        NumberParser parser = new NumberParser();
        parser.parse(String.join(" ", args));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Вы не указали аргументы");
      }
      /*
        Pattern p = Pattern.compile("([I|V|X|L|C|D|M|0-9]+)\\s+[\\+|\\-|\\*|\\/]\\s+([I|V|X|L|C|D|M|0-9]+)");
        Matcher m = p.matcher(args[0]);
        if (m.find()) {
          System.out.println("Вы ввели допустимое выражение!!!");
          /*
          try {
            System.out.println(args[0]);
            try {
              System.out.println(NumberParser.parse(args[0]));
            } catch (IllegalArgumentException e) {
              // Обработка арабских цифр
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Вы использовали по крайней мере одну цифру > 10");
            }
          } catch (IndexOutOfBoundsException e) {
              System.out.println("Вы не указали аргументы");
          }
        } else {
            System.out.println("Вы ввели недопустимое выражение!");
        }
    */
    }
}
