package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListExampleTheFirst {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        String longest = "";
        for (String element : list) {
            if (element.length() > longest.length()) {
                longest = element;
            }
        }
        
        System.out.println("Longest Element: " + longest);
        
        //................................................
        
        List<Integer> myList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myList.add(random.nextInt(101));
        }
        System.out.println(myList);
    }
}
