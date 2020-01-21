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
          System.out.println(goldNumber);
        }
      }
    }
    HashSet<String> hashSet = new HashSet<>(list);
    TreeSet<String> treeSet = new TreeSet<>(list);

    while (true) {
      System.out.print("Ведите желаемый номер ----> ");
      String s = (new Scanner(System.in)).nextLine();

      long start1 = System.currentTimeMillis();
      list.contains(s);
      long duration1 = System.currentTimeMillis() - start1;
      System.out.println("Прямой переобор: " + duration1);

      long start2 = System.currentTimeMillis();
      Collections.binarySearch(list, s);
      long duration2 = System.currentTimeMillis() - start2;
      System.out.println("Бинарным поиском: " + duration2);

      long start3 = System.currentTimeMillis();
      treeSet.contains(s);
      long duration3 = System.currentTimeMillis() - start3;
      System.out.println("TreeSet: " + duration3);

      long start4 = System.currentTimeMillis();
      hashSet.contains(s);
      long duration4 = System.currentTimeMillis() - start4;
      System.out.println("HashSet: " + duration4);
    }
  }
}
