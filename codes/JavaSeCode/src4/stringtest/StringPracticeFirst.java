package stringtest;

import java.util.Scanner;
import java.util.Random;

public class StringPracticeFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name in the format 'FIRST LAST':");
        String fullName = scanner.nextLine();
        int count = fullName.replace(" ", "").length();
        System.out.println("Number of characters (excluding spaces): " + count);
        char[] charArray = { 'A', 'B', 'C', 'D', 'E' };
        String str = new String(charArray);
        System.out.println("String from character array: " + str);
        Random random = new Random();
        int number = 10 + random.nextInt(21);
        System.out.println("Random number between 10 and 30: " + number);
        System.out.println("Checking if the full name ends with 'LAST': " + endsWith(fullName, "LAST"));
    }

    public static boolean endsWith(String str1, String str2) {
        return str1.endsWith(str2);
    }
}
