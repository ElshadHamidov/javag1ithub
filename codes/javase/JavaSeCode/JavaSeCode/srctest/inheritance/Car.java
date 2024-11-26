package inheritance;

public class Car extends Vehicle {
    int doors;

    Car(String brand, int speed, int doors) {
        super(brand, speed);
        this.doors = doors;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("Doors: " + doors);
    }
}