package inheritance;

public class MainClass {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota", 120);
        vehicle.showInfo();

        System.out.println();

        Car car = new Car("Mercedes", 240, 4);
        car.showInfo();
    }
}