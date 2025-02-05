package polymorphisms;

public class MobilePayments extends DigitalPayments {
    @Override
    public void processPayment(double amount) {
        System.out.println("Mobil cihaz ilə ödəniş: " + amount + " AZN ödənildi.");
    }

    @Override
    public String getPaymentType() {
        return "Mobil ödənişi";
    }
}
