package calculate;

public class MethodsReturn {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        double avg1 = calc.average(10, 20);
        System.out.println(avg1);
        double avg2 = calc.average(7, 3);
        System.out.println(avg2);
    }
}
