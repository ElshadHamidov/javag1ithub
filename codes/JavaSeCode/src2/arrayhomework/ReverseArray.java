package arrayhomework;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] numbers = {1,4,2,3,6};
		int[] descending = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            descending[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println(Arrays.toString(descending));
    }

}
