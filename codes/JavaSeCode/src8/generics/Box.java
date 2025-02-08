package generics;

public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println(intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello, Generic!");
        System.out.println(strBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.set(3.14);
        System.out.println(doubleBox.get());
    }
}
