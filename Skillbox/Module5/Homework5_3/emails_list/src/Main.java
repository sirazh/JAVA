import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /*
    Написать программу, в которой будет храниться перечень e-mail-ов. E-mail’ы  можно добавлять через консоль командой
    ADD и печатать весь список командой LIST.

    * Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.
     */

    public static void main(String[] args) {
      //  System.out.println("Hello World!");

        HashSet<String> emaillist = new HashSet<>();
        String s;
        System.out.println("Вам необходимо ввести e-mail c консоли . Примеры команд: \n" +
                "    LIST - выводит список всех электронных адресов в базе\n" +
                "    ADD vasya@pupkin.ru - добавляет e-mail к списку\n");
        while (true) {
            System.out.print("ВВЕДИТЕ КОМАНДУ ----> ");
            s = (new Scanner(System.in)).nextLine().trim();

            Pattern twopart = Pattern.compile("([A-Z]+)\\s*([a-zA-Z]\\w+@\\w+\\.\\D{2,4})*");

            Matcher m = twopart.matcher(s);
            if (m.matches()) {
                String command = m.group(1);
                String item = m.group(2);
                if (command.equals("LIST")) {
                    if (!emaillist.isEmpty()) {
                        System.out.println("Перечень e-mail-ов: ");
                        for (String email : emaillist) {
                            System.out.println(email);
                        }
                    } else {
                        System.out.println("Перечень e-mail-ов пока пуст");
                    }

                } else if (command.equals("ADD")) {
                      emaillist.add(item);

                } else if (command.equals("EXIT")) {
                    System.out.println("Введена команда завершения ввода");
                    break;
                } else {
                    System.out.println("Команда не распознана");
                }


            } else System.out.println("E-mail введен некорректно!");

        }

    }
}
