package lesson11;

public class PerfectNumber {
    public PerfectNumber(int p) {
        int sum = 0;
        for (int i = 1; i < p; i++) {
            if (p % i == 0) {
                sum += i;
            }
        }
        if (sum == p) {
            System.out.println(p + " is a perfect number");
        } else {
            System.out.println(p + " is an unperfect number");
        }
    }

    public static void main(String[] args) {
        PerfectNumber pn = new PerfectNumber(6);
        PerfectNumber pn2 = new PerfectNumber(28);
        PerfectNumber pn3 = new PerfectNumber(12);
    }
}
