package dovr;

import java.util.Scanner;

public class JavaTest {
    public static void main(String[] args) {
        // int sum=0;
        // float i=0;
        // while (i<=5) {
        //     i+=0.1;
        //     System.out.println(i);
        // }
        // }
        // System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("Sum of Number: " + sum);
        scanner.close();
    }
}
