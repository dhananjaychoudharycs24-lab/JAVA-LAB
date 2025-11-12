import java.util.Scanner;


class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

 
    public void withdraw(double amount) {
        System.out.println("Withdrawal logic is specific to account type.");
    }

    public void computeAndDepositInterest() {
        System.out.println("Interest computation is specific to account type.");
    }
}


class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000;
    private static final double PENALTY_CHARGE = 50; 

    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }


    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (amount > 0 && balance - amount < MIN_BALANCE && balance - amount >= 0) {
            balance -= amount;
            balance -= PENALTY_CHARGE;
            System.out.println("Withdrawal successful, but balance fell below minimum. Penalty imposed: " + PENALTY_CHARGE);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }


    public void computeAndDepositInterest() {
        System.out.println("Current accounts do not earn interest.");
    }
}


class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.04; 

    public SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }


    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public void computeAndDepositInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest of " + interest + " deposited. New balance: " + balance);
    }
}


public class Account1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Current Account
        CurAcct currentAccount = new CurAcct("Alice", "CA12345", 1500);
        System.out.println("\nCurrent Account Details:");
        currentAccount.displayBalance();

        currentAccount.deposit(200);
        currentAccount.withdraw(300); 
        currentAccount.withdraw(500); 
        currentAccount.computeAndDepositInterest(); 

        SavAcct savingsAccount = new SavAcct("DJ", "SA67890", 2000);
        System.out.println("\nSavings Account Details:");
        savingsAccount.displayBalance();

        savingsAccount.deposit(500);
        savingsAccount.withdraw(1000);
        savingsAccount.computeAndDepositInterest();

        scanner.close();
    }
}