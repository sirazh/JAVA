import java.util.Scanner;
import java.util.TreeMap;

    /*Написать программу, которая будет работать как телефонная книга: если пишем новое имя, просит ввести номер телефона
    и запоминает его, если новый номер телефона — просит ввести имя и тоже запоминает. Если вводим существующее имя
    или номер телефона, программа должна выводить всю информацию о контакте. При вводе команды LIST программа должна
    печатать в консоль список всех абонентов в алфавитном порядке с номерами.*/

public class Main {
    private static final String NAME = "([а-яА-Я]+)|([a-zA-Z]+)";
    private static final String PHONE = "\\d{10}";
    private static final String COMMAND_LIST = "LIST";
    private static final String COMMAND_EXIT = "EXIT";

    private static TreeMap<String,String> phonebook = new TreeMap();

    public static void main(String[] args) {

        String input;
             while (true) {
            System.out.print("\nВведите имя или номер телефона: ");
            input = (new Scanner(System.in)).nextLine().trim();

            String  input_ = cleanPhoneNumber(input);

            if (input.matches(COMMAND_LIST)) {
                list();
            } else if (input.matches(COMMAND_EXIT)) {
                exit();
               break;

            } else if (input.matches(NAME)) {

                inputCheck(PHONE,input);

            } else if (input_.matches(PHONE)) {
                inputCheck(NAME,input_);
            } else {
                System.out.println("Команда не распознана");
            }
        }

    }
    private static void inputCheck (String regex, String s)
    {
        if  (phonebook.containsKey(s) | phonebook.containsValue(s))

        {
            printIfContains(s);
        }
        else
        {
            addNewRecord(regex,s);
        }
    }

    private static String cleanPhoneNumber(String s)   {
        String phoneStr = s.replaceAll("[^0-9]", "");
        if (phoneStr.length() == 11) {
            phoneStr = phoneStr.substring(1);
        }
        return  phoneStr;
    }

    private static void list () {
        if (!phonebook.isEmpty()) {
            System.out.println("Перечень контактов: ");
            for (String key : phonebook.keySet()){
                System.out.println(key + ": +7" + phonebook.get(key));
            }
        } else {
            System.out.println("Телефонная книга пока пуста");
        }
    }
    private static void exit () {
        System.out.println("Введена команда завершения ввода");
        System.out.println("До встречи!");
    }

    private static void printIfContains (String s) {
        if (s.matches(PHONE))
        {
            String name = "";
            for (String key : phonebook.keySet()){
                name = phonebook.get(key);
                if (s.equals(phonebook.get(key)))
                {
                    System.out.println("Запись найдена: " + key + ": +7" + s);
                    break;
                }
            }

        } else if (s.matches(NAME)){
            System.out.println("Запись найдена: " + s + ": +7" + phonebook.get(s));
        }
    }

    private static void addNewRecord (String regex, String s) {

        String inputStr = "";
        while (!inputStr.matches(regex))
        {
            System.out.print("Введите " + (regex == PHONE ? "номер телефона: " : "имя: "));
           inputStr = new Scanner(System.in).nextLine().trim();
           if (regex == PHONE) {
               inputStr = cleanPhoneNumber(inputStr);
               phonebook.put(s,inputStr);
            } else {
               phonebook.put(inputStr,s);
           }
            System.out.print("В телефонную книгу добавлен новый контакт: " + (regex == PHONE ? s : inputStr));
        }
    }
}
