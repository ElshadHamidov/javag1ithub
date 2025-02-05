package idunno;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + "\nPrice: $" + price + "\nQuantity: " + quantity;
    }
}