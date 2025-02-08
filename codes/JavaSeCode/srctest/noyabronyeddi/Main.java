package noyabronyeddi;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(1, "Laptop", 1000);
        product.applySale(product.getPrice());
        System.out.println("ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
    }

}
