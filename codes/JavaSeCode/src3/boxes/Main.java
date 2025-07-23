package boxes;

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.addItem(123);
        intBox.showItem();

        Box<String> strBox = new Box<>();
        strBox.addItem("Salam");
        strBox.showItem();
    }
}