Как писать решения на Java
http://acm.timus.ru/help.aspx?topic=java

С 1 июня 2006 года Timus Online Judge поддерживает язык программирования Java. Для компиляции и запуска решений на Java используется J2SE Development Kit (JDK) 7.0 Update 11 (до 18 января 2013 использовался JDK 6.0, до 2 февраля 2009 использовался JDK 5.0). Вы можете скачать JDK и прочитать online документацию на официальном сайте.

Программы на Java запускаются на сервере с командной строкой:

java -Xmx64m -Xss64m -DONLINE_JUDGE YourClassName
Как должно выглядеть решение на Java

Программа на Java, посылаемая на проверку, должна содержать ровно один public класс. Этот класс может называться как угодно и он должен содержать метод "public static void main(String[] args)". Кроме того, программа может содержать любое количество вложенных классов и глобальных непубличных классов. Вот пример решения задачи A + B:

import java.io.*;
import java.util.*;

public class Sum
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int a = in.nextInt();
      int b = in.nextInt();
      out.println(a + b);

      out.flush();
   }
}
Это решение тоже является правильным:

import java.util.*;

class YouCanUseSuchClasses {}
public class Sum2
{
   class AndSuchClassesToo {}
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println(in.nextInt() + in.nextInt());
   }
}
Время работы и используемая память

Решения на Java почти всегда работают достаточно большое время и требуют много памяти по сравнению с другими языками независимо от сложности задачи. Такова особенность этого языка. Но, тем не менее, гарантируется, что почти все задачи на Timus Online Judge могут быть сданы на Java без особых проблем по сравнению с другими языками. Вот список всех задач, для которых это не гарантируется: 1220, 1275, 1306.

Локализация

По умолчанию на сервере используется локаль Locale.US. Если вы установите в своей программе другую локаль, это может повлиять на способность Вашей программы читать/писать числа с плавающей точкой.

Ввод/вывод

Ввод/вывод в Java может стать очень медленным, если пользоваться им неправильно. Вот несколько правил, соблюдая которые, вы сможете избежать проблем, связанных со вводом/выводом:

Scanner является самым удобным средством для чтения входных данных в большинстве задач, но скорость его работы оставляет желать лучшего. Используйте его только для чтения небольших входных данных.
BufferedReader обеспечивает достаточно быстрый ввод для большинства задач. Но самостоятельно этот класс позволяет лишь читать отдельные символы и строки. Для чтения токенов и чисел используйте StringTokenizer или StreamTokenizer.
PrintWriter подходит для всех случаев и работает достаточно быстро. Но его метод printf работает медленно; также медленно работают вызовы типа println(a + " " + b). Выводите по одной переменной за раз, и тогда вы добьетесь максимальной эффективности.
Вот пример эффективного использования классов StreamTokenizer и PrintWriter (задача — вывести через пробел сумму и разность чисел A и B, записанных во входных данных):

import java.io.*;
import java.util.*;

public class SumDif
{
   public static void main(String[] args) throws IOException
   {
      new SumDif().run();
   }

   StreamTokenizer in;
   PrintWriter out;

   int nextInt() throws IOException
   {
      in.nextToken();
      return (int)in.nval;
   }

   void run() throws IOException
   {
      in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      out.flush();
   }

   void solve() throws IOException
   {
      int a = nextInt();
      int b = nextInt();
      out.print(a + b);
      out.print(" ");
      out.println(a - b);
   }
}
Для того чтобы читать и выводить символы с кодами больше 127 также как и в других языках программирования следует использовать следующие конструкторы:

Scanner scanner = new Scanner(System.in, "ISO-8859-1");
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
Это нужно делать, так как насчет кодировки по умолчанию на сервере ничего не гарантируется. Скорее всего, использование кодировки по умолчанию приведет к тому, что часть символов с кодами 128-255 будут преобразованы в символы Unicode с кодами больше 255. А при выводе эти символы могут замениться, например, на вопросительные знаки.

Использование свойства ONLINE_JUDGE

Запуск программы на сервере осуществляется с определенным свойством ONLINE_JUDGE. С его помощью в коде программы можно определить, что она запущена на сервере. Например, это можно использовать для решения, использовать ли для работы файлы или стандартный ввод/вывод:

boolean oj = System.getProperty("ONLINE_JUDGE") != null;
Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
StreamTokenizer in = new StreamTokenizer(new BufferedReader(reader));
PrintWriter out = new PrintWriter(writer);