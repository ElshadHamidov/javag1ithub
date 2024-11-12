package stringtest;

import java.util.Scanner;

public class StringPracticeFirst {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Please enter your full name in the format 'FIRST LAST':");
         String fullName = scanner.nextLine();
         int count =fullName.replace(" ", "").length();
         System.out.println(count);
    }
}
