import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /*

    Разработать список дел, которым можно управлять командами в консоли. Команды LIST, ADD, EDIT, DELETE.
    LIST должен выводить дела с их порядковыми номерами. ADD - добавлять дело в конец списка или дело на
    определённое место, сдвигая остальные дела вперёд, если указать номер. EDIT - заменять дело с указанным
    номером. DELETE - удалять. Примеры команд:

    LIST
    ADD Какое-то дело
    ADD 4 Какое-то дело на четвёртом месте
    EDIT 3 Новое название дела
    DELETE 7

     */

    public static void main(String[] args) {

        ArrayList<String> todolist = new ArrayList<>();
        String s;
        System.out.println("Вам необходимо ввести команду с консоли. Примеры команд: \n" +
                "    LIST\n" +
                "    ADD Какое-то дело\n" +
                "    ADD 4 Какое-то дело на четвёртом месте\n" +
                "    EDIT 3 Новое название дела\n" +
                "    DELETE 7");
        while (true) {
            System.out.print("ВВЕДИТЕ КОМАНДУ ----> ");
            s = (new Scanner(System.in)).nextLine().trim();

            Pattern threepart = Pattern.compile("([A-Z]+)\\s*([0-9]+\\s+)*(.*)");

            Matcher m = threepart.matcher(s);
            if (m.matches()) {
                String command = m.group(1);
                String digitStr = m.group(2);
                if (digitStr == null) {
                    digitStr ="";
                }else {
                    digitStr = digitStr.trim();
                }

                String item = m.group(3);
                if (command.equals("LIST")) {
                    if (!todolist.isEmpty()) {
                        System.out.println("Твой список дел: ");
                        for (int i = 0; i < todolist.size(); i++) {
                            System.out.println(i + " - " + todolist.get(i));
                        }
                    } else {
                            System.out.println("Список дел пока пуст");
                    }

                } else if (command.equals("ADD")) {
                    if (digitStr.equals("")) {
                        todolist.add(item);
                    } else if (Integer.parseInt(digitStr) < todolist.size()){

                        todolist.add(Integer.parseInt(digitStr), item);
                    } else {
                        todolist.add(item);
                    }

                } else if (command.equals("EDIT")) {
                    todolist.remove(Integer.parseInt(digitStr));
                    todolist.add(Integer.parseInt(digitStr), item);
                } else if (command.equals("DELETE")) {
                    todolist.remove(Integer.parseInt(digitStr));
                } else if (command.equals("EXIT")) {
                    System.out.println("Введена команда завершения ввода");
                    break;
                } else {
                    System.out.println("Команда не распознана");
                }


            } else System.out.println("Введите корректные данные!");

        }

   }
}
