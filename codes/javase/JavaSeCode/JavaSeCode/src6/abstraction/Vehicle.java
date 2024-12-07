package abstraction;

public abstract class Vehicle {
    public abstract void move();

    public void showType(String type) {
        System.out.println("Type: " + type);
    }
}
