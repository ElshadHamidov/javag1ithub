package october12024;

public class Methods {

    public void printName(int count, String name) {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.printName(1, "Kyler");
        methods.printName(2, "Katie");
        methods.printName(3, "Bob");
    }
}
