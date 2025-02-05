package abstracted;

public class CurrentAccount extends BankAccount {
    private double balance;

    public CurrentAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("CurrentAccount - Amount Deposited: " + amount);
        System.out.println("CurrentAccount - Current Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("CurrentAccount - Balansınızda kifayət qədər vəsait yoxdur...");
        } else {
            balance -= amount;
            System.out.println("CurrentAccount - Amount Withdrawn: " + amount);
            System.out.println("CurrentAccount - Remaining Balance: " + balance);
        }
    }
}

