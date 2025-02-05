package enmu;

import java.util.Scanner;

public class Mugen {

	enum Season {
		SPRING, SUMMER, FALL, WINTER
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your favorite season (Spring, Summer, Fall, Winter):");
		String favorite = scanner.nextLine().toUpperCase();
		Season season = Season.valueOf(favorite);

		switch (season) {
		case SPRING:
			System.out.println("Spring: Entertainment District Arc");
			break;
		case SUMMER:
			System.out.println("Summer: Swordsmith Village Arc");
			break;
		case FALL:
			System.out.println("Fall: Mugen Train Arc");
			break;
		case WINTER:
			System.out.println("Winter: Final Battle Arc");
			break;
		}
	}
}
