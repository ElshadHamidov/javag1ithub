package polymorphisms;

public class CashPayments implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Nağd olaraq: " + amount + " AZN ödənildi.");
    }

    @Override
    public String getPaymentType() {
        return "Nağd ödəniş";
    }
}