package encapsulation;

public class Main {
    public static void main(String[] args) {
        InventoryItem item = new InventoryItem();

        item.setName("Laptop");
        item.setQuantity(10);
        item.setPrice(1500.0);

        System.out.println("Name: " + item.getName());
        System.out.println("Quantity: " + item.getQuantity());
        System.out.println("Price: " + item.getPrice());

        item.setQuantity(-5);
        item.setPrice(-200.0);

        System.out.println("Updated Quantity: " + item.getQuantity());
        System.out.println("Updated Price: " + item.getPrice());
    }
}

