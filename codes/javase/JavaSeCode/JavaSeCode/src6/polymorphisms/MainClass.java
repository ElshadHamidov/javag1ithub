package polymorphisms;

public class MainClass {
	public static void main(String[] args) {
		Payment cardPayment = new CardPayments();
		Payment mobilePayment = new MobilePayments();
		Payment cashPayment = new CashPayments();
		
		cardPayment.processPayment(100);
		System.out.println("Ödəniş növü: " + cardPayment.getPaymentType());
		
		mobilePayment.processPayment(50);
		System.out.println("Ödəniş növü: " + mobilePayment.getPaymentType());

		cashPayment.processPayment(20);
		System.out.println("Ödəniş növü: " + cashPayment.getPaymentType());
	}
}