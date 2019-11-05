package jcalc;

import java.util.Scanner;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
      while (true) {
        System.out.print("Введите выражение: ");
        Scanner in = new Scanner(System.in);
        String phrase = in.nextLine();
        if (phrase.trim().equals("exit")) {
          break;
        }
        if (phrase.trim().length() == 0) {
          System.out.println("Вы не ввели выражение!");
          continue;
        }
        NumberParser parser = new NumberParser();
        parser.parse(phrase.trim());
      }
    }
}
