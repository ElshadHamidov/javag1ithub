package extended;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        double discountedPrice = price * 0.80;
        System.out.println("Discounted Price (Electronic): " + discountedPrice);
        return discountedPrice;
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        double discountedPrice = price * 0.85;
        System.out.println("Discounted Price (Clothing): " + discountedPrice);
        return discountedPrice;
    }
}
