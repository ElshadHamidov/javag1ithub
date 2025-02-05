package extended;

public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double calculateDiscount() {
        double discountedPrice = price * 0.90;
        System.out.println("Discounted Price (Product): " + discountedPrice);
        return discountedPrice;
    }
}