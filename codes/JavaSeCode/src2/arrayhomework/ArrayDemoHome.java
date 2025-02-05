package arrayhomework;

import java.util.Arrays;

public class ArrayDemoHome {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 7, 3};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Massivin elementlərinin cəmi: " + sum);

        System.out.println("Massivin elementləri: " + Arrays.toString(numbers));

        double average = (double) sum / numbers.length;
        System.out.println("Massivin elementlərinin ədədi ortası: " + average);

        Arrays.sort(numbers);
        int min = numbers[0];
        System.out.println("Massivin ən kiçik elementi: " + min);

        int max = numbers[numbers.length - 1];
        System.out.println("Massivin ən böyük elementi: " + max);

        System.out.print("Tək elementlər: ");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Cüt elementlər: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Sadə ədədlər: ");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        Arrays.sort(numbers);
        int[] sortedDescending = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sortedDescending[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println("Azalan sıra ilə massivin elementləri: " + Arrays.toString(sortedDescending));
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

