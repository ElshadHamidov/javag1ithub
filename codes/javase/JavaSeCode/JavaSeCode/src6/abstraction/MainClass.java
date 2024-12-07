package abstraction;

public class MainClass {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        
        car.move();
        car.showType("Car");

        bike.move();
        bike.showType("Bike");
    }
}
