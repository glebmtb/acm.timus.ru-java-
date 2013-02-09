package task1000;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Вычислите a+b
 * <p/>
 * Исходные данные
 * a и b
 * <p/>
 * Результат
 * a+b
 *
 * @author Belyaev
 */
public class Sum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int a = in.nextInt();
    int b = in.nextInt();
    out.println(a + b);

    out.flush();
  }
}

