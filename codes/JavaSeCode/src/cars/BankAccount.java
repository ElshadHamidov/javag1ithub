package cars;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Yatırılan məbləğ müsbət olmalıdır.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Çıxarış üçün kifayət qədər vəsait yoxdur və ya məbləğ düzgün deyil.");
        }
    }

    public void displayBalance() {
        System.out.println("Hesab nömrəsi: " + accountNumber + " - Mövcud balans: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 500.0);
        account.displayBalance();
        account.deposit(200);
        account.displayBalance();
        account.withdraw(100);
        account.displayBalance();
        account.withdraw(700);
        account.deposit(100);
        account.displayBalance();
        account.withdraw(700);
        account.displayBalance();
    }
}
