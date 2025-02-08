package mapusage;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> fruits = new HashMap<>();

        fruits.put("Apple", 3);
        fruits.put("Banana", 5);
        fruits.put("Cherry", 10);

        System.out.println("Initial Map: " + fruits);

        fruits.put("Apple", 5);

        System.out.println("Updated Map: " + fruits);
    }
}
