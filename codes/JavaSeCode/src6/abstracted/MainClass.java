package abstracted;

public class MainClass {
    public static void main(String[] args) {
        BankAccount savingAccount = new SavingAccount();
        BankAccount currentAccount = new CurrentAccount();

        System.out.println("Saving Account Operations:");
        savingAccount.deposit(500);
        savingAccount.withdraw(200);
        savingAccount.withdraw(400);

        System.out.println("Current Account Operations:");
        currentAccount.deposit(1000);
        currentAccount.withdraw(300);
        currentAccount.withdraw(800);
    }
}
