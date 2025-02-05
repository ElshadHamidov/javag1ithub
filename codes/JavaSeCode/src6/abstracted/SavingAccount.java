package abstracted;

public class SavingAccount extends BankAccount {
	private double balance;

    public SavingAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("SavingAccount - Amount Deposited: " + amount);
        System.out.println("SavingAccount - Current Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("SavingAccount - Balansınızda kifayət qədər vəsait yoxdur...");
        } else {
            balance -= amount;
            System.out.println("SavingAccount - Amount Withdrawn: " + amount);
            System.out.println("SavingAccount - Remaining Balance: " + balance);
        }
    }
}
