package october12024;

public class MethodsReturn {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double result1 = calculator.average(4, 8);
        System.out.println("First average: " + result1);

        double result2 = calculator.average(10, 20);
        System.out.println("Second average: " + result2);
    }
}

class Calculator {

    public double average(int num1, int num2) {
        return (num1 + num2) / 2.0;
    }
}
