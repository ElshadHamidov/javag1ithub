package dovr;

import java.util.Scanner;

public class JavaTest {
    public static void main(String[] args) {
        // int sum=0;
        // float i=0;
        // while (i<=5) {
        // i+=0.1;
        // System.out.println(i);
        // }
        // }
        // System.out.println(sum);
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the number: ");
        // int number = scanner.nextInt();
        // int sum = 0;

        // while (number != 0) {
        // sum += number % 10;
        // number /= 10;
        // }

        // System.out.println("Sum of Numbers: " + sum);
        // scanner.close()
        // for (int i = 1; i < 200; i++) {
        //     if (i % 3 == 0 && i % 7 == 0) {
        //         System.out.println(i);
        //     }
        // }
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number you like: ");
        int number = scanner.nextInt();
        
        int f = 1;
        
        while (number > 0) {
            f*=number;
            number--;

        }

        System.out.println("Factorial: " + f);

        scanner.close();
    }
}
