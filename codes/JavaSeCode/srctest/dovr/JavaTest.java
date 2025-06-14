package dovr;

import java.util.Scanner;

public class JavaTest {
    public static void main(String[] args) {
        // int sum=0;
        // for(int i=1; i<=100; i++){
        // sum+=i;
        // if(i%7==0){
        // System.out.println(i);
        // }
        // }
        // System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        if (number % 2 == 0) {
            System.out.println("Cüt ədəddir");
        } else {
            System.out.println("Tək ədəddir");
        }
    }
}
