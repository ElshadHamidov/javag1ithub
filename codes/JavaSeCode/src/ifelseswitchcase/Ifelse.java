package ifelseswitchcase;

public class Ifelse {
    public static void main(String[] args) {
        int age = 0;
        if (age <= 17) {
            System.out.println("You are just a child");
        } else {
            System.out.println("You are a grown up");
        }

        int a = 0;
        int b = 0;
        if (a < b) {
            System.out.println(b + " is bigger");
        } else if (a > b) {
            System.out.println(a + " is bigger");
        } else {
            System.out.println("They are equal");
        }

        int r = 70;
        int f = 70;
        if (r >= 60 && f >= 60) {
            System.out.println("Congratulations, you passed both subjects!");
        } else if (r < 60 && f < 60) {
            System.out.println("You failed");
        } else {
            System.out.println("You passed one of the subjects");
        }
    }
}