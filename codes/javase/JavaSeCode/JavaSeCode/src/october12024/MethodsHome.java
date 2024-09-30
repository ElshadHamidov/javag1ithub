package october12024;

public class MethodsHome {

    public void printNumbers(int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MethodsHome methodsHome = new MethodsHome();
        
        methodsHome.printNumbers(1, 5);
        methodsHome.printNumbers(10, 15);
        methodsHome.printNumbers(20, 25);
    }
}
