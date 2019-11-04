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
    }
}
