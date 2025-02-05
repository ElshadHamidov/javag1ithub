package idunno;

public class Main {
 public static void main(String[] args) {
     Product product1 = new Product("Laptop", 1200.50, 10);
     Product product2 = new Product("Smartphone", 799.99, 25);
     Product product3 = new Product("Headphones", 199.99, 50);

     System.out.println(product1);
     System.out.println("_______________________");
     System.out.println(product2);
     System.out.println("_______________________");
     System.out.println(product3);
 }
}
