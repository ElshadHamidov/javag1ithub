package massive;

import java.util.Random;

public class Massive {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[4];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        for (int i = 0; i < arr.length; i++) {
            sum = arr[i] * 2;
            System.out.println("Number: " + arr[i] + ", Doubled: " + sum);
        }
    }
}
