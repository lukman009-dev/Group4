// ============================================
// Base Class - BankAccount
// ============================================
class BankAccount {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited TZS " + amount);
        System.out.println("New Balance: TZS " + balance);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrew TZS " + amount);
            System.out.println("New Balance: TZS " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: TZS " + balance);
    }

    // Calculate interest (default = 0)
    public double calculateInterest() {
        return 0;
    }
}

// ============================================
// SavingsAccount Class (Inheritance)
// ============================================
class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Override interest calculation
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    // Override withdraw (minimum 10,000 balance)
    @Override
    public void withdraw(double amount) {
        if ((balance - amount) < 10000) {
            System.out.println("Minimum balance of TZS 10,000 required.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrew TZS " + amount);
            System.out.println("New Balance: TZS " + balance);
        }
    }

    // Apply interest
    public void applyInterest() {
        double interest = calculateInterest();
        balance = balance + interest;
        System.out.println("Interest Added: TZS " + interest);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
    }
}

// ============================================
// CurrentAccount Class
// ============================================
class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder,
                          double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance = balance - amount;
            System.out.println("Withdrew TZS " + amount);
            System.out.println("New Balance: TZS " + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Current");
    }
}

// ============================================
// FixedDepositAccount Class
// ============================================
class FixedDepositAccount extends BankAccount {

    private double interestRate;
    private int months;
    private boolean matured;

    public FixedDepositAccount(String accountNumber, String accountHolder,
                               double balance, double interestRate, int months) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.months = months;
        matured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (months / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (!matured) {
            System.out.println("Cannot withdraw before maturity.");
        } else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkMaturity() {
        matured = true;
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit");
    }
}

// ============================================
// Bank Class (Using Polymorphism)
// ============================================
class Bank {

    private BankAccount[] accounts;
    private int count = 0;

    public Bank(int size) {
        accounts = new BankAccount[size];
    }

    public void addAccount(BankAccount account) {
        accounts[count] = account;
        count++;
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + accounts[i].calculateInterest();
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            System.out.println("---------------------");
            accounts[i].displayAccountInfo();
        }
    }
}

// ============================================
// Main Class
// ============================================
public class Exercise13_Polymorphism {

    // Method Overloading
    public static void transferMoney(BankAccount from,
                                     BankAccount to,
                                     double amount) {

        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("Transfer Completed.");
    }

    public static void transferMoney(BankAccount from,
                                     BankAccount to,
                                     double amount,
                                     String note) {

        System.out.println("Note: " + note);
        transferMoney(from, to, amount);
    }

    public static void main(String[] args) {

        System.out.println("=== BANK SYSTEM TEST ===");

        SavingsAccount savings =
                new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);

        CurrentAccount current =
                new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);

        FixedDepositAccount fixed =
                new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);

        // Testing Savings
        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();

        // Testing Current
        current.displayAccountInfo();
        current.withdraw(1200000);
        System.out.println("Overdrawn? " + current.isOverdrawn());

        // Testing Bank
        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        System.out.println("\n--- Bank Summary ---");
        bank.displayAllAccounts();
        System.out.println("Total Deposits: TZS " + bank.getTotalDeposits());
        System.out.println("Total Interest: TZS " + bank.getTotalInterest());

        // Transfer Test
        System.out.println("\n--- Transfer Test ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, savings, 30000, "Rent Payment");

        System.out.println("=== END ===");
    }
}
