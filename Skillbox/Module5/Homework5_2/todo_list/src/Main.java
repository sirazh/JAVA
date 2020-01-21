import java.util.ArrayList;
import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Main {

    public static final String COMMAND_ADD = "ADD\\s+.+";
    public static final String COMMAND_ADD_TO_INDEX = "ADD\\s+\\d+\\s+.+";
    public static final String COMMAND_EDIT = "EDIT\\s+\\d+\\s+.+";
    public static final String COMMAND_DELETE = "DELETE\\s+\\d+";
    public static final String COMMAND_LIST = "LIST";
    public static final String COMMAND_EXIT = "EXIT";

    public static ArrayList<String> todolist = new ArrayList<>();

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
        String input;
        System.out.println("Вам необходимо ввести команду с консоли. Примеры команд: \n" +
                "    LIST\n" +
                "    ADD Какое-то дело\n" +
                "    ADD 4 Какое-то дело на четвёртом месте\n" +
                "    EDIT 3 Новое название дела\n" +
                "    DELETE 7");
        while (true) {
            System.out.print("ВВЕДИТЕ КОМАНДУ ----> ");
            input = (new Scanner(System.in)).nextLine().trim();

            if (input.matches(COMMAND_ADD_TO_INDEX)) {
                addToIndex(input);
            } else if (input.matches(COMMAND_ADD)) {
                add(input);
            } else if (input.matches(COMMAND_LIST)) {
                list();
            } else if (input.matches(COMMAND_EDIT)) {
                edit(input);
            } else if (input.matches(COMMAND_DELETE)) {
                delete(input);
            } else if (input.matches(COMMAND_EXIT)) {
                exit();
                break;
            } else {
                System.out.println("Команда не распознана");
            }
        }
   }

   public static void add (String s) {
        String [] addStr = s.split("\\s+",2);
        todolist.add(addStr[1]);
   }
    public static void addToIndex (String s) {
        String [] addStrIndex = s.split("\\s+",3);
        int index = Integer.parseInt(addStrIndex[1]);
        if (checkIndex(index)) {
            todolist.add(index, addStrIndex[2]);
        } else {
            todolist.add(addStrIndex[2]);
        }
    }
    public static void edit (String s) {
        String [] editStr = s.split("\\s+",3);
        int index = Integer.parseInt(editStr[1]);
        if (checkIndex(index)){
            todolist.remove(index);
            todolist.add(index, editStr[2]);
        } else outOfIndex(index);


    }

    public static void delete (String s) {
        String [] delStr = s.split("\\s+",2);
        int index = Integer.parseInt(delStr[1]);
        if (checkIndex(index)){
            todolist.remove(index);
        } else outOfIndex(index);

    }

    public static void list () {
        if (!todolist.isEmpty()) {
            System.out.println("Твой список дел: ");
            for (int i = 0; i < todolist.size(); i++) {
                System.out.println(i + " - " + todolist.get(i));
            }
        } else {
            System.out.println("Список дел пока пуст");
        }
    }
    public static void exit () {
        System.out.println("Введена команда завершения ввода");
    }

    public static boolean checkIndex (int index){
        return index < todolist.size();
    }
    public static void outOfIndex (int index){
        System.out.println("Индекс " + index +" превышает допустимое значение! Введите значение от 0 до " + (todolist.size()-1));
    }
}


