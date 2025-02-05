package polymorphisms;

public class DigitalPayments implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Ödəniş işlənir...");
    }

    @Override
    public String getPaymentType() {
        return "Digital Payment";
    }
    
    public void verifyTransaction() {
        System.out.println("Ödəniş təsdiqlənir...");
    }
}