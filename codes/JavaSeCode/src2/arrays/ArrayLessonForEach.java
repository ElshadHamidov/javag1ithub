package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLessonForEach {
	public static void main(String[] args) {
//		String[] books = new String[5];
//		Scanner bookscan = new Scanner(System.in);
//		for (int i=0; i<books.length; i++) {
//			books[i]= bookscan.nextLine();
//		}
//		for (String book : books) {
//			System.out.println(book);
//		}
		int[] array8number = {1,2,3,4,5,6,7,8};
		int[] array4number = Arrays.copyOfRange(array8number, 3, 7);
		System.out.println(Arrays.toString(array4number));
	}
}
