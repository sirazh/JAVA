import java.util.*;

public class Main {

  public static void main(String[] args) {

    List<String> numbers;
    numbers = Arrays.asList("C", "M", "T", "B", "A", "P", "O", "H", "E", "Y");
    TreeSet<String> number = new TreeSet<>(numbers);

    ArrayList<String> list = new ArrayList<>();

    for (String s : number) {
      for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 198; j++) {
          String region = "" + j;
          while (region.length() < 3) {
            region = "0" + region;
          }
          String goldNumber = s + i + i + i + s + s + region;
          list.add(goldNumber);
        }
      }
    }
    HashSet<String> hashSet = new HashSet<>(list);
    TreeSet<String> treeSet = new TreeSet<>(list);
    String s = "";
    while (!s.equals("EXIT")) {
      System.out.print("Ведите желаемый номер ----> ");
      s = (new Scanner(System.in)).nextLine();

      System.out.println(
          "Поиск перебором: " + isFound(list, s) + ", поиск занял " + durationTime(list, s)
              + " нс");
      System.out.println(
          "Бинарный поиск: " + isFound(list, s) + ", поиск занял " + durationTime(list, 2, s)
              + " нс");
      System.out.println(
          "Поиск в TreeSet: " + isFound(treeSet, s) + ", поиск занял " + durationTime(treeSet, s)
              + " нс");
      System.out.println(
          "Поиск в HashSet: " + isFound(hashSet, s) + ", поиск занял " + durationTime(hashSet, s)
              + " нс");
    }
  }

  public static long durationTime(Collection obj, String searchStr) {
    long start = System.nanoTime();
    obj.contains(searchStr);
    return System.nanoTime() - start;
  }

  public static long durationTime(Collection obj, int i, String searchStr) {
    long start = System.nanoTime();
    if (i == 2) {
      List binar = (List) obj;
      Collections.binarySearch(binar, searchStr);
    }
    return System.nanoTime() - start;
  }

  public static String isFound(Collection obj, String str) {
    return obj.contains(str) ? "номер найден" : "номер не найден";
  }
}
