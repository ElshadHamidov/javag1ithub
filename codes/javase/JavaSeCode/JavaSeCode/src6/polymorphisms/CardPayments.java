package polymorphisms;

public class CardPayments extends DigitalPayments {
    @Override
    public void processPayment(double amount) {
        System.out.println("Kart ilə ödəniş: " + amount + " AZN ödənildi.");
    }

    @Override
    public String getPaymentType() {
        return "Kart ödənişi";
    }
}
