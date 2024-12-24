package listed;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 10; evenNumbers.size() < 40; i += 2) {
            evenNumbers.add(i);
        }
        System.out.println("Task 1 - Even Numbers List:");
        System.out.println(evenNumbers);

        //....................................................................................
        
        List<String> stringList = List.of("hello", "world", "java", "programming", "example");
        List<String> reversedList = new ArrayList<>();
        for (String s : stringList) {
            reversedList.add(new StringBuilder(s).reverse().toString());
        }
        System.out.println("\nTask 2 - Original String List:");
        System.out.println(stringList);
        System.out.println("Task 2 - Reversed String List:");
        System.out.println(reversedList);
    }
}
