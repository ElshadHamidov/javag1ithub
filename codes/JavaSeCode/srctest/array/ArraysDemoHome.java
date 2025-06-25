package array;

public class ArraysDemoHome {
    public static void main(String[] args) {
        int[] numbers = {7, 15, 2, 10};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Sum (with for loop): " + sum);

        System.out.print("Array values (with foreach loop): ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);

        int min = numbers[0];
        int max = numbers[0];
        for (int number : numbers) {
            if (number < min) min = number;
            if (number > max) max = number;
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);

        System.out.print("Odd numbers: ");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        System.out.print("Even numbers: ");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        System.out.print("Prime numbers: ");
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        java.util.Arrays.sort(numbers);
        System.out.print("Sorted in descending order: ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
