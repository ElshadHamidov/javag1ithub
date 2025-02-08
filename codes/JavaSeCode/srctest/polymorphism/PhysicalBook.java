package polymorphism;

public class PhysicalBook extends Book {
    double weight;
    String measure;
    public PhysicalBook(String name, String author, double weight, String measure) {
        super(name, author);
        this.weight = weight;
        this.measure = measure;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Measure: " + measure);
    }
}

