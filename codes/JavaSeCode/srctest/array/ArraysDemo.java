package array;

import java.util.Random;

public class ArraysDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[5];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Sum of numbersay elements: " + sum);

        double average = (double) sum / numbers.length;
        System.out.println("Average of numbersay elements: " + average);

        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum element in the numbersay: " + min);

        System.out.print("Odd elements in the numbersay: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
