package lesson10;

public class Heron {
    public static double area(int a, int b, int c) {
        int p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        int a = 2, b = 2, c = 2;
        double area = area(a, b, c);
        System.out.println("The area of the triangle is: " + area);
    }
}
