package cars;

public class Cars {
    private String model;
    private int year;
    private int speed;

    public Cars(String model, int year) {
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    public void start() {
        System.out.println("Avtomobil işə salındı.");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("Sürət " + increment + " vahid artırıldı. Cari sürət: " + speed);
    }

    public void brake(int decrement) {
        if (speed >= decrement) {
            speed -= decrement;
            System.out.println("Sürət " + decrement + " vahid azaldıldı. Cari sürət: " + speed);
        } else {
            System.out.println("Sürət bu qədər azaldıla bilməz");
        }
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", İl: " + year + ", Sürət: " + speed);
    }

    public static void main(String[] args) {
        Cars car = new Cars("BMW", 2023);
        car.start();
        car.accelerate(50);
        car.brake(20);
        car.displayInfo();
        car.brake(40);
    }
}
